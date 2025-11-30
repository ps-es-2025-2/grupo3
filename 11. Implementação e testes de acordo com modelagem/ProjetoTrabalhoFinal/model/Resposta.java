package model;

import java.util.Date;

public class Resposta {
    private Long id;
    private String valor;
    private Date dataResposta;
    private Long perguntaId;
    private Long usuarioId;

    public Resposta(Long id, String valor, Long perguntaId, Long usuarioId) {
        this.id = id;
        this.valor = valor;
        this.perguntaId = perguntaId;
        this.usuarioId = usuarioId;
        this.dataResposta = new Date();
    }

    public void salvarResposta() {
        System.out.println("Resposta salva: " + valor);
    }

    public Integer calcularPontuacao() {
        return 0; // Lógica de pontuação
    }
}