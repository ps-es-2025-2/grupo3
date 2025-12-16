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

    @FXML private TextField txtEmail;
    @FXML private PasswordField txtSenha;
    @FXML private Label lblMensagem;

    @FXML
    protected void onLoginClick() {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        if (email.isEmpty() || senha.isEmpty()) {
            lblMensagem.setText("Preencha todos os campos.");
            return;
        }

        Usuario usuarioLogado = Repositorio.autenticarUsuario(email, senha);

        if (usuarioLogado != null) {
            try {
                if (usuarioLogado instanceof Psicologo) {
                    abrirDashboardPsicologo((Psicologo) usuarioLogado);
                } 
                else if (usuarioLogado instanceof Aluno) {
                    abrirDashboardAluno((Aluno) usuarioLogado);
                }
            } catch (IOException e) {
                e.printStackTrace();
                lblMensagem.setText("Erro crítico ao abrir o painel.");
            }
        } else {
            lblMensagem.setText("Email ou senha inválidos.");
        }
    }

    @FXML
    public void onIrParaCadastroAluno() {
        abrirTelaCadastro(false);
    }

    @FXML
    public void onIrParaCadastroPsi() {
        abrirTelaCadastro(true); 
    }

    private void abrirTelaCadastro(boolean modoPsicologo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroUsuario.fxml"));
            Parent root = loader.load();
            
            CadastroUsuarioController controller = loader.getController();
            controller.setModoPsicologo(modoPsicologo);
            
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(modoPsicologo ? "Novo Psicólogo" : "Novo Aluno");
            stage.centerOnScreen();
            
        } catch (IOException e) {
            e.printStackTrace();
            lblMensagem.setText("Erro ao carregar tela de cadastro.");
        }
    }

    private void abrirDashboardPsicologo(Psicologo psi) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
        Parent root = loader.load();
        
        DashboardPsicologoController controller = loader.getController();
        controller.initData(psi); 

        trocarCena(root, "Portal do Psicólogo");
    }

    private void abrirDashboardAluno(Aluno aluno) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
        Parent root = loader.load();
        
        DashboardAlunoController controller = loader.getController();
        controller.initData(aluno);
        
        trocarCena(root, "Painel do Aluno");
    }

    private void trocarCena(Parent root, String titulo) {
        Stage stage = (Stage) txtEmail.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.show();
        stage.centerOnScreen();
    }
}