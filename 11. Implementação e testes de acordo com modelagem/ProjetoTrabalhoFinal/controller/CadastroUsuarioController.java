package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Aluno;
import model.Psicologo;
import model.Repositorio;
import java.io.IOException;

public class CadastroUsuarioController {

    @FXML private Label lblTitulo;
    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtSenha;
    @FXML private Label lblDocumento;
    @FXML private TextField txtDocumento;
    @FXML private Label lblExtra;
    @FXML private TextField txtExtra;
    @FXML private Label lblMensagem;
    
    private boolean isPsicologo = false;

    public void setModoPsicologo(boolean isPsicologo) {
        this.isPsicologo = isPsicologo;
        
        if (isPsicologo) {
            lblTitulo.setText("Cadastro de Psicólogo");
            lblDocumento.setText("CRP:");
            txtDocumento.setPromptText("Ex: 06/12345");
            
            lblExtra.setVisible(false);
            txtExtra.setVisible(false); 
        } else {
            lblTitulo.setText("Cadastro de Aluno");
            lblDocumento.setText("CPF:");
            txtDocumento.setPromptText("Apenas números");
            
            lblExtra.setVisible(true);
            lblExtra.setText("Escola:");
            txtExtra.setVisible(true);
        }
    }
    
    
    @FXML
    public void onCadastrar() {
        if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDocumento.getText().isEmpty()) {
            lblMensagem.setText("Preencha os campos obrigatórios.");
            return;
        }

        try {
            if (isPsicologo) {
                Psicologo p = new Psicologo(null, txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtDocumento.getText());
                Repositorio.cadastrarPsicologo(p);
            } else {
                Aluno a = new Aluno(null, txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtDocumento.getText());
                a.setEscola(txtExtra.getText());
                Repositorio.cadastrarAluno(a);
            }

            lblMensagem.setStyle("-fx-text-fill: green;");
            lblMensagem.setText("Cadastrado com sucesso!");
            limparCampos();

        } catch (Exception e) {
            lblMensagem.setStyle("-fx-text-fill: red;");
            lblMensagem.setText("Erro ao cadastrar.");
            e.printStackTrace();
        }
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) txtNome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtSenha.clear();
        txtDocumento.clear();
        txtExtra.clear();
    }
}