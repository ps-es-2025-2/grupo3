package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Aluno;
import model.Consulta;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AgendamentoController {

    @FXML private DatePicker dtData;
    @FXML private ComboBox<String> cbHorario;
    @FXML private TextArea txtObservacoes;
    @FXML private Label lblStatus;

    private Aluno alunoLogado;

    @FXML
    public void initialize() {
        cbHorario.getItems().addAll("08:00", "09:00", "10:00", "14:00", "15:00", "16:00");
    }

    public void initData(Aluno aluno) {
        this.alunoLogado = aluno;
    }

    @FXML
    public void onConfirmar() {
        LocalDate dataSelecionada = dtData.getValue();
        String horaSelecionada = cbHorario.getValue();

        if (dataSelecionada == null || horaSelecionada == null) {
            lblStatus.setText("Por favor, selecione data e horário.");
            return;
        }

        LocalTime hora = LocalTime.parse(horaSelecionada);
        LocalDateTime dataHora = LocalDateTime.of(dataSelecionada, hora);

        Consulta novaConsulta = new Consulta(System.currentTimeMillis(), dataHora);
        
        lblStatus.setStyle("-fx-text-fill: green;");
        lblStatus.setText("Agendado com sucesso para " + dataHora);
        
        dtData.setDisable(true);
        cbHorario.setDisable(true);
    }

    @FXML
    public void onVoltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml"));
            Parent root = loader.load();
            
            DashboardAlunoController dashboardController = loader.getController();
            dashboardController.initData(this.alunoLogado);
            
            Stage stage = (Stage) dtData.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}