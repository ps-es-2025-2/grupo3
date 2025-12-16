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

    // --- LÓGICA DE LOGIN (Via Banco de Dados) ---

    @FXML
    protected void onLoginClick() {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        // Validação simples
        if (email.isEmpty() || senha.isEmpty()) {
            lblMensagem.setText("Preencha todos os campos.");
            return;
        }

        // Chama o Repositorio, que agora consulta o PostgreSQL via UsuarioDAO
        Usuario usuarioLogado = Repositorio.autenticarUsuario(email, senha);

        if (usuarioLogado != null) {
            try {
                // Verifica se o usuário encontrado é um PSICÓLOGO
                if (usuarioLogado instanceof Psicologo) {
                    abrirDashboardPsicologo((Psicologo) usuarioLogado);
                } 
                // Verifica se o usuário encontrado é um ALUNO
                else if (usuarioLogado instanceof Aluno) {
                    abrirDashboardAluno((Aluno) usuarioLogado);
                }
            } catch (IOException e) {
                e.printStackTrace();
                lblMensagem.setText("Erro crítico ao abrir o painel.");
            }
        } else {
            // Se retornou null, o email ou senha estão incorretos (ou não existem no banco)
            lblMensagem.setText("Email ou senha inválidos.");
        }
    }

    // --- NAVEGAÇÃO PARA CADASTRO (Reutilizando a View) ---

    @FXML
    public void onIrParaCadastroAluno() {
        abrirTelaCadastro(false); // false = Modo Aluno
    }

    @FXML
    public void onIrParaCadastroPsi() {
        abrirTelaCadastro(true); // true = Modo Psicólogo
    }

    // Método auxiliar para abrir a tela de cadastro genérica
    private void abrirTelaCadastro(boolean modoPsicologo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroUsuario.fxml"));
            Parent root = loader.load();
            
            // Configura o controlador da tela de cadastro
            CadastroUsuarioController controller = loader.getController();
            controller.setModoPsicologo(modoPsicologo);
            
            // Troca a cena
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(modoPsicologo ? "Novo Psicólogo" : "Novo Aluno");
            stage.centerOnScreen();
            
        } catch (IOException e) {
            e.printStackTrace();
            lblMensagem.setText("Erro ao carregar tela de cadastro.");
        }
    }

    // --- MÉTODOS AUXILIARES PARA ABRIR DASHBOARDS ---

    private void abrirDashboardPsicologo(Psicologo psi) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
        Parent root = loader.load();
        
        DashboardPsicologoController controller = loader.getController();
        controller.initData(psi); // Passa os dados do banco para o controller

        trocarCena(root, "Portal do Psicólogo");
    }

    private void abrirDashboardAluno(Aluno aluno) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
        Parent root = loader.load();
        
        DashboardAlunoController controller = loader.getController();
        controller.initData(aluno); // Passa os dados do banco para o controller
        
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