package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Questionario {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean ativo;
    private Date dataCriacao;
    private List<Pergunta> perguntas;

    public Questionario(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.dataCriacao = new Date();
        this.perguntas = new ArrayList<>();
        this.ativo = true;
    }

    public void adicionarPergunta(Pergunta p) {
        this.perguntas.add(p);
    }

    public void removerPergunta(Pergunta p) {
        this.perguntas.remove(p);
    }

    public void ativarQuestionario() { this.ativo = true; }
    public void desativarQuestionario() { this.ativo = false; }

    public Map<String, Object> calcularResultado() {
        // Lógica de cálculo seria implementada aqui
        return null; 
    }
    
    public String getTitulo() { return titulo; }
}