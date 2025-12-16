package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import model.*;

public class GerarLaudoController {
    @FXML private ComboBox<Aluno> cbAlunos;
    @FXML private TextArea txtConteudo;
    @FXML private Label lblMensagem;
    
    private Psicologo psicologoLogado;

    public void initData(Psicologo psi) {
        this.psicologoLogado = psi;
        
        cbAlunos.getItems().clear();
        cbAlunos.getItems().addAll(Repositorio.getAlunos());
        
        cbAlunos.setCellFactory(param -> new ListCell<Aluno>() {
            @Override protected void updateItem(Aluno item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNome());
            }
        });
        cbAlunos.setButtonCell(cbAlunos.getCellFactory().call(null));
    }

    @FXML
    public void onSalvar() {
        Aluno alunoSelecionado = cbAlunos.getValue();
        String texto = txtConteudo.getText();

        if (alunoSelecionado != null && !texto.isEmpty()) {
            Laudo novoLaudo = new Laudo(System.currentTimeMillis(), alunoSelecionado, psicologoLogado);
            novoLaudo.setConteudo(texto);
            
            Repositorio.adicionarLaudo(novoLaudo);
            
            lblMensagem.setStyle("-fx-text-fill: green;");
            lblMensagem.setText("Laudo salvo com sucesso!");
            txtConteudo.setDisable(true);
        } else {
            lblMensagem.setText("Preencha todos os campos.");
        }
    }
    
    @FXML
    public void onCancelar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPsicologo.fxml"));
            Parent root = loader.load();
            DashboardPsicologoController controller = loader.getController();
            controller.initData(this.psicologoLogado);
            
            Stage stage = (Stage) cbAlunos.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch(Exception e) { e.printStackTrace(); }
    }
}