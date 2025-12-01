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

    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
        this.dataCadastro = new Date();
    }

    public Boolean login(String email, String senha) {
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
        return Map.of("nome", nome, "email", email);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
}