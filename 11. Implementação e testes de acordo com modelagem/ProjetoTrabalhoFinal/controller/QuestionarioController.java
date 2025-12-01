package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionarioController {

    @FXML private Label lblTitulo;
    @FXML private VBox containerPerguntas;
    @FXML private Label lblMensagem;

    private Aluno alunoLogado;
    private Questionario questionarioAtual;
    
    // Mapa para relacionar a Pergunta (Model) ao Grupo de Botões (View)
    private Map<Pergunta, ToggleGroup> mapaRespostas = new HashMap<>();

    public void initData(Aluno aluno, Questionario questionario) {
        this.alunoLogado = aluno;
        this.questionarioAtual = questionario; // Usa o que foi passado
        
        // Se por acaso veio nulo (teste), cria o mock. Se não, renderiza o real.
        if (this.questionarioAtual == null) {
            criarQuestionarioMock();
        }
        
        renderizarPerguntas();
    }

    private void criarQuestionarioMock() {
        // Instancia o questionário
        questionarioAtual = new Questionario(101L, "Avaliação de Bem-Estar Escolar");
        
        // Pergunta 1
        Pergunta p1 = new Pergunta(1L, "1. Como você tem se sentido na escola ultimamente?", "MULTIPLA");
        p1.adicionarOpcaoResposta("Muito bem");
        p1.adicionarOpcaoResposta("Normal");
        p1.adicionarOpcaoResposta("Ansioso(a)");
        
        // Pergunta 2
        Pergunta p2 = new Pergunta(2L, "2. Você tem conseguido dormir bem?", "MULTIPLA");
        p2.adicionarOpcaoResposta("Sim, durmo bem");
        p2.adicionarOpcaoResposta("Mais ou menos");
        p2.adicionarOpcaoResposta("Não, tenho insônia");

        // Pergunta 3
        Pergunta p3 = new Pergunta(3L, "3. Sente dificuldade em concentrar-se nas aulas?", "MULTIPLA");
        p3.adicionarOpcaoResposta("Raramente");
        p3.adicionarOpcaoResposta("Às vezes");
        p3.adicionarOpcaoResposta("Frequentemente");

        // Adiciona as perguntas à lista do objeto Questionario
        questionarioAtual.adicionarPergunta(p1);
        questionarioAtual.adicionarPergunta(p2);
        questionarioAtual.adicionarPergunta(p3);
    }

private void renderizarPerguntas() {
        if (questionarioAtual == null) {
             lblTitulo.setText("Erro: Nenhum questionário carregado.");
             return;
        }
        
        lblTitulo.setText(questionarioAtual.getTitulo());
        containerPerguntas.getChildren().clear();
        mapaRespostas.clear();

        // Pega as perguntas do objeto real
        List<Pergunta> listaDePerguntas = questionarioAtual.getPerguntas();

        if (listaDePerguntas == null || listaDePerguntas.isEmpty()) {
            lblMensagem.setText("Este questionário não possui perguntas.");
            return;
        }

        for (Pergunta p : listaDePerguntas) {
            Label lblEnunciado = new Label(p.getEnunciado());
            lblEnunciado.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 10 0 5 0;");
            
            VBox boxOpcoes = new VBox(5); 
            ToggleGroup grupo = new ToggleGroup();
            
            for (String textoOpcao : p.obterOpcoesResposta()) {
                RadioButton rb = new RadioButton(textoOpcao);
                rb.setToggleGroup(grupo);
                rb.setUserData(textoOpcao);
                boxOpcoes.getChildren().add(rb);
            }

            containerPerguntas.getChildren().addAll(lblEnunciado, boxOpcoes);
            mapaRespostas.put(p, grupo);
        }
    }

    @FXML
    public void onEnviar() {
        int respondidas = 0;
        int total = mapaRespostas.size();
        
        for (Map.Entry<Pergunta, ToggleGroup> entrada : mapaRespostas.entrySet()) {
            ToggleGroup g = entrada.getValue();
            if (g.getSelectedToggle() != null) {
                respondidas++;
            }
        }

        if (respondidas == total && total > 0) {
            // Cria o objeto QuestionarioRespondido
            QuestionarioRespondido qr = new QuestionarioRespondido(alunoLogado, questionarioAtual);
            
            for (Map.Entry<Pergunta, ToggleGroup> entrada : mapaRespostas.entrySet()) {
                String enunciado = entrada.getKey().getEnunciado();
                String resposta = entrada.getValue().getSelectedToggle().getUserData().toString();
                qr.adicionarResposta(enunciado, resposta);
            }
            
            // Salva no Repositório
            Repositorio.adicionarQuestionarioRespondido(qr);

            lblMensagem.setStyle("-fx-text-fill: green;");
            lblMensagem.setText("Enviado para o psicólogo com sucesso!");
            containerPerguntas.setDisable(true);
            
        } else {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("Responda todas as perguntas (" + respondidas + "/" + total + ").");
        }
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
            Parent root = loader.load();
            
            DashboardAlunoController controller = loader.getController();
            controller.initData(this.alunoLogado);
            
            Stage stage = (Stage) lblTitulo.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}