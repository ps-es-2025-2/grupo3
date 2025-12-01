package model;

import java.time.LocalDateTime;

public class Consulta {
    private Long id;
    private LocalDateTime dataHora;
    private Integer duracao;
    private String status;
    private String linkMeet;
    private Long alunoId;
    private Long psicologoId;
    private String observacoes;
    
    private API_Google apiGoogle;

    public Consulta(Long id, LocalDateTime dataHora) {
        this.id = id;
        this.dataHora = dataHora;
        this.apiGoogle = new API_Google();
    }

    public void agendarConsulta() {
        this.status = "AGENDADA";
        this.linkMeet = gerarLinkGoogleMeet();
        System.out.println("Consulta agendada para: " + dataHora);
    }

    public String gerarLinkGoogleMeet() {
        return apiGoogle.gerarLinkMeet();
    }
    
    public void cancelarConsulta() { this.status = "CANCELADA"; }
}