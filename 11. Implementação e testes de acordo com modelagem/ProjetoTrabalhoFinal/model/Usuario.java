package model;

import java.util.Date;
import java.util.Map;

public abstract class Usuario {
    protected Long id;
    protected String nome;
    protected String email;
    protected String senha;
    protected Date dataCadastro;
    protected Boolean ativo;
    protected Boolean consentimentoLGPD;

    // Construtor vazio
    public Usuario() {}

    // Construtor completo
    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
        this.dataCadastro = new Date();
    }

    // Métodos do Diagrama
    public Boolean login(String email, String senha) {
        // Lógica simplificada para teste
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        System.out.println("Usuário " + this.nome + " deslogado.");
    }

    public void atualizarDados() {
        System.out.println("Dados atualizados.");
    }

    public Boolean validarCredenciais() {
        return this.email != null && this.senha != null;
    }

    public void consentirDados() {
        this.consentimentoLGPD = true;
    }

    public Map<String, Object> acessarDadosPessoais() {
        // Retorna um mapa simulando os dados
        return Map.of("nome", nome, "email", email);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
}