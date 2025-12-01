package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Aluno;
import model.Questionario;
import model.Repositorio;
import javafx.util.Callback;

public class SelecionarQuestionarioController {

    @FXML private ListView<Questionario> listaQuestionarios;
    @FXML private Label lblMensagem;

    private Aluno alunoLogado;

    public void initData(Aluno aluno) {
        this.alunoLogado = aluno;
        carregarLista();
    }

    private void carregarLista() {
        listaQuestionarios.getItems().clear();
        listaQuestionarios.getItems().addAll(Repositorio.getQuestionarios());

        listaQuestionarios.setCellFactory(param -> new ListCell<Questionario>() {
            @Override
            protected void updateItem(Questionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getTitulo() == null) {
                    setText(null);
                } else {
                    setText(item.getTitulo());
                }
            }
        });
    }

    @FXML
    public void onIniciar() {
        Questionario selecionado = listaQuestionarios.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("Selecione um questionário na lista.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Questionario.fxml"));
            Parent root = loader.load();
            
            QuestionarioController controller = loader.getController();
            
            controller.initData(this.alunoLogado, selecionado);
            
            Stage stage = (Stage) listaQuestionarios.getScene().getWindow();
            stage.setScene(new Scene(root));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
            Parent root = loader.load();
            DashboardAlunoController controller = loader.getController();
            controller.initData(this.alunoLogado);
            
            Stage stage = (Stage) listaQuestionarios.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) { e.printStackTrace(); }
    }
}