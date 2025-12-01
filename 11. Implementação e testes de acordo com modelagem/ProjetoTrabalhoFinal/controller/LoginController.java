package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Imports do Model
import model.Aluno;
import model.Usuario;
import model.Psicologo;     
import model.Repositorio;   

import java.io.IOException;      // Para tratar erros ao ler o arquivo

public class LoginController {

    // Componentes mapeados do FXML
    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;

    // Método disparado ao clicar no botão
    @FXML
    protected void onLoginClick() {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        // Inicializa o repositório de dados falsos
        model.Repositorio.inicializarMock();

        if (email.contains("psi")) {
            // --- LÓGICA DE PSICÓLOGO ---
            // Login fixo para teste: ana@psi.com / 123456
            if (senha.equals("123456")) {
                try {
                    // Carrega Dashboard do Psicólogo
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
                    Parent root = loader.load();
                    
                    // Passa dados do psicólogo (MOCK)
                    Psicologo psiMock = new Psicologo(99L, "Dra. Ana", email, senha, "CRP-12345");
                    controller.DashboardPsicologoController dashPsi = loader.getController();
                    dashPsi.initData(psiMock);

                    Stage stage = (Stage) txtEmail.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Portal do Psicólogo");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                lblMensagem.setText("Senha de psicólogo inválida.");
            }

        } else {
            // --- LÓGICA DE ALUNO (Mantém a anterior) ---
            Usuario usuarioDoBanco = new Aluno(1L, "João da Silva", "joao", "123456", "111.222.333-44");
            if (usuarioDoBanco.login(email, senha)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
                    Parent root = loader.load();
                    DashboardAlunoController dashboardController = loader.getController();
                    dashboardController.initData((Aluno) usuarioDoBanco);
                    
                    Stage stage = (Stage) txtEmail.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) { e.printStackTrace(); }
            } else {
                lblMensagem.setText("Login inválido.");
            }
        }
    }
}
