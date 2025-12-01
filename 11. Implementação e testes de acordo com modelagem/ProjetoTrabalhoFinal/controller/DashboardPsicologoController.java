package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Psicologo;
import java.io.IOException;

public class DashboardPsicologoController {

    @FXML 
    private Label lblNome;
    
    private Psicologo psicologoLogado;

    public void initData(Psicologo p) {
        this.psicologoLogado = p;
        if (lblNome != null) {
            lblNome.setText("Olá, " + p.getNome());
        }
    }

    @FXML
    public void onNovoLaudo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GerarLaudo.fxml"));
            Parent root = loader.load();
            
            GerarLaudoController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            
            Stage stage = (Stage) lblNome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void onAvaliarQuestionarios() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AvaliarQuestionario.fxml"));
            Parent root = loader.load();
            
            AvaliarQuestionarioController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            
            Stage stage = (Stage) lblNome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML
    public void onCadastrarQuestionarios() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastrarQuestionario.fxml"));
            Parent root = loader.load();
            
            CadastrarQuestionarioController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            
            Stage stage = (Stage) lblNome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSair() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) lblNome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}