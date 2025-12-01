package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import java.io.IOException;
import java.util.Map;

public class AvaliarQuestionarioController {

    @FXML private ListView<QuestionarioRespondido> listaPendentes;
    @FXML private TextArea txtRespostas;
    @FXML private TextArea txtFeedback;
    @FXML private Label lblStatus;

    private Psicologo psicologoLogado;
    private QuestionarioRespondido itemSelecionado;

    public void initData(Psicologo psi) {
        this.psicologoLogado = psi;
        carregarLista();
    }

    private void carregarLista() {
        listaPendentes.getItems().clear();
        listaPendentes.getItems().addAll(Repositorio.getQuestionariosPendentes());
    }

    @FXML
    public void onSelecionarItem() {
        itemSelecionado = listaPendentes.getSelectionModel().getSelectedItem();
        
        if (itemSelecionado != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Aluno: ").append(itemSelecionado.getAluno().getNome()).append("\n");
            sb.append("Questionário: ").append(itemSelecionado.getQuestionario().getTitulo()).append("\n\n");
            
            for (Map.Entry<String, String> entry : itemSelecionado.getRespostasDetalhadas().entrySet()) {
                sb.append("• ").append(entry.getKey()).append("\n");
                sb.append("   R: ").append(entry.getValue()).append("\n\n");
            }
            
            txtRespostas.setText(sb.toString());
            txtFeedback.clear();
            lblStatus.setText("");
        }
    }

    @FXML
    public void onSalvarFeedback() {
        if (itemSelecionado == null) {
            lblStatus.setText("Selecione um item da lista.");
            return;
        }
        
        String feedbackTexto = txtFeedback.getText();
        if (feedbackTexto.isEmpty()) {
            lblStatus.setText("O feedback não pode estar vazio.");
            return;
        }

        itemSelecionado.registrarFeedback(feedbackTexto);
        
        Laudo laudoFeedback = new Laudo(System.currentTimeMillis(), itemSelecionado.getAluno(), psicologoLogado);
        laudoFeedback.setConteudo("FEEDBACK - " + itemSelecionado.getQuestionario().getTitulo() + ":\n" + feedbackTexto);
        
        Repositorio.adicionarLaudo(laudoFeedback);

        lblStatus.setStyle("-fx-text-fill: green;");
        lblStatus.setText("Feedback enviado com sucesso!");
        txtRespostas.clear();
        txtFeedback.clear();
        
        carregarLista();
        itemSelecionado = null;
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
            Parent root = loader.load();
            DashboardPsicologoController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            Stage stage = (Stage) listaPendentes.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) { e.printStackTrace(); }
    }
}