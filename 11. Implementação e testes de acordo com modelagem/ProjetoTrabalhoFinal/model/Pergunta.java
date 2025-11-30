package model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    private Long id;
    private String enunciado;
    private String tipo; // Ex: "MULTIPLA_ESCOLHA", "TEXTO"
    private List<String> opcoes;
    private Boolean obrigatoria;
    private Integer ordem;

    public Pergunta(Long id, String enunciado, String tipo) {
        this.id = id;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.opcoes = new ArrayList<>();
        this.obrigatoria = true;
    }

    public void adicionarOpcaoResposta(String opcao) {
        this.opcoes.add(opcao);
    }

    public List<String> obterOpcoesResposta() {
        return this.opcoes;
    }
    
    // Getters
    public Long getId() { return id; }
    public String getEnunciado() { return enunciado; }
}