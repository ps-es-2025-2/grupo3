package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class CadastrarQuestionarioController {

    @FXML private TextField txtTituloQuestionario;
    @FXML private TextField txtEnunciado;
    @FXML private TextField txtOpcoes; 
    @FXML private ListView<String> listaPerguntasAdicionadas;
    @FXML private Label lblMensagem;

    private Psicologo psicologoLogado;
    private Questionario questionarioEmEdicao;

    public void initData(Psicologo psi) {
        this.psicologoLogado = psi;
        this.questionarioEmEdicao = new Questionario(System.currentTimeMillis(), "");
    }

    @FXML
    public void onAdicionarPergunta() {
        String enunciado = txtEnunciado.getText();
        String opcoesStr = txtOpcoes.getText();

        if (enunciado.isEmpty() || opcoesStr.isEmpty()) {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("Preencha o enunciado e as opções.");
            return;
        }

        Pergunta p = new Pergunta(System.nanoTime(), enunciado, "MULTIPLA");
        
        String[] opcoesArray = opcoesStr.split(";");
        for (String op : opcoesArray) {
            p.adicionarOpcaoResposta(op.trim());
        }

        questionarioEmEdicao.adicionarPergunta(p);

        listaPerguntasAdicionadas.getItems().add(enunciado + " (" + opcoesArray.length + " opções)");
        
        txtEnunciado.clear();
        txtOpcoes.clear();
        lblMensagem.setText("");
        txtEnunciado.requestFocus();
    }

    @FXML
    public void onSalvarQuestionario() {
        String titulo = txtTituloQuestionario.getText();
        
        if (titulo.isEmpty()) {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("O questionário precisa de um título.");
            return;
        }

        if (questionarioEmEdicao.getPerguntas().isEmpty()) {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("Adicione pelo menos uma pergunta.");
            return;
        }

        Questionario questionarioFinal = new Questionario(System.currentTimeMillis(), titulo);
        for(Pergunta p : questionarioEmEdicao.getPerguntas()) {
            questionarioFinal.adicionarPergunta(p);
        }

        Repositorio.adicionarQuestionario(questionarioFinal);

        lblMensagem.setStyle("-fx-text-fill: green;");
        lblMensagem.setText("Questionário cadastrado com sucesso!");
        
        txtTituloQuestionario.setDisable(true);
        txtEnunciado.setDisable(true);
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
            Parent root = loader.load();
            
            DashboardPsicologoController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            
            Stage stage = (Stage) txtTituloQuestionario.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}