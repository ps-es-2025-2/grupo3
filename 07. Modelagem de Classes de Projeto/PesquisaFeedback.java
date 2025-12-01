package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PesquisaFeedback {
    private Long id;
    private String titulo;
    private Boolean ativa;
    private List<Pergunta> perguntas;

    public PesquisaFeedback(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.perguntas = new ArrayList<>();
        this.ativa = true;
    }
    
    public void registrarResposta(Resposta r) {
        System.out.println("Feedback recebido.");
    }
}