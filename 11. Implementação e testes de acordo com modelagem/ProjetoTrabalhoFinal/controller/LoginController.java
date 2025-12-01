package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.Aluno;
import model.Usuario;
import model.Psicologo;     
import model.Repositorio;   

import java.io.IOException;    

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;

    @FXML
    protected void onLoginClick() {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        model.Repositorio.inicializarMock();

        if (email.contains("psi")) {
            if (senha.equals("123456")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
                    Parent root = loader.load();
                    
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
