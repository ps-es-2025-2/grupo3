package controller;

import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Aluno;
import java.io.IOException;

public class DashboardAlunoController {

    @FXML
    private Label lblBemVindo;

    private Aluno alunoLogado;

    public void initData(Aluno aluno) {
        this.alunoLogado = aluno;
        lblBemVindo.setText("Bem-vindo, " + aluno.getNome());
    }

    @FXML
    public void onResponderQuestionario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SelecionarQuestionario.fxml"));
            Parent root = loader.load();
            
            SelecionarQuestionarioController controller = loader.getController();
            controller.initData(this.alunoLogado); 
            
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onMeusLaudos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MeusLaudos.fxml"));
            Parent root = loader.load();
            
            MeusLaudosController controller = loader.getController();
            
            controller.initData(this.alunoLogado);
            
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir a tela de Meus Laudos.");
        }
    }   
    
    @FXML
    public void onAgendarConsulta() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Agendamento.fxml"));
            Parent root = loader.load();
            
            AgendamentoController agendamentoController = loader.getController();
            agendamentoController.initData(this.alunoLogado);
            
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir tela de agendamento: " + e.getMessage());
        }
    }
    @FXML
    public void onSair() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}