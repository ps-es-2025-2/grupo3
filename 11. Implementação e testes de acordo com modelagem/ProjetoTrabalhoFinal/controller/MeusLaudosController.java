package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import model.Aluno;
import model.Laudo;
import model.Repositorio;
import java.util.List;

public class MeusLaudosController {
    @FXML private ListView<String> listaLaudos;
    private Aluno alunoLogado;

    public void initData(Aluno aluno) {
        this.alunoLogado = aluno;
        carregarLaudos();
    }

    private void carregarLaudos() {
        // Busca do "Banco de Dados" estático
        List<Laudo> laudos = Repositorio.getLaudosDoAluno(alunoLogado.getId());
        
        listaLaudos.getItems().clear();
        if (laudos.isEmpty()) {
            listaLaudos.getItems().add("Nenhum laudo encontrado.");
        } else {
            for (Laudo l : laudos) {
                // Formata a string para aparecer na lista
                String item = "Data: " + l.toString() + "\nConteúdo: " + l.getConteudo(); 
                // Nota: implemente toString() em Laudo ou use formatação de data
                listaLaudos.getItems().add(item);
            }
        }
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
            Parent root = loader.load();
            DashboardAlunoController controller = loader.getController();
            controller.initData(this.alunoLogado);
            Stage stage = (Stage) listaLaudos.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch(Exception e) { e.printStackTrace(); }
    }
}