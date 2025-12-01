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

    // Método especial para receber dados de outra tela
    public void initData(Aluno aluno) {
        this.alunoLogado = aluno;
        lblBemVindo.setText("Bem-vindo, " + aluno.getNome());
    }

    @FXML
    public void onResponderQuestionario() {
        try {
            // MUDANÇA: Carrega a tela de Seleção em vez da tela do Questionário direto
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SelecionarQuestionario.fxml"));
            Parent root = loader.load();
            
            SelecionarQuestionarioController controller = loader.getController();
            controller.initData(this.alunoLogado); // Passa o aluno para a tela de seleção
            
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onMeusLaudos() {
        try {
            // 1. Carregar a tela de visualização de laudos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MeusLaudos.fxml"));
            Parent root = loader.load();
            
            // 2. Obter o controlador da tela de laudos
            MeusLaudosController controller = loader.getController();
            
            // 3. Passar o aluno logado para que o controlador saiba de quem buscar os laudos
            controller.initData(this.alunoLogado);
            
            // 4. Trocar a cena
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
            
            // Passa o usuário logado para a tela de agendamento
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
            // Volta para a tela de Login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            
            // Pega o palco (janela) atual e muda a cena
            Stage stage = (Stage) lblBemVindo.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}