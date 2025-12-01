package model;

import java.util.Date;

public class Aluno extends Usuario {
    private String cpf;
    private Date dataNascimento;
    private String escola;
    private String serie;

    public Aluno(Long id, String nome, String email, String senha, String cpf) {
        super(id, nome, email, senha);
        this.cpf = cpf;
    }

    public void responderQuestionario(Questionario q) {
        System.out.println("Aluno respondendo questionário: " + q.getTitulo());
    }

    public void visualizarProgresso() {
        System.out.println("Visualizando progresso...");
    }

    public void acessarLaudos() {
        System.out.println("Acessando laudos...");
    }

    public void agendarConsulta() {
        System.out.println("Iniciando agendamento...");
    }

    public void responderPesquisa() {
        System.out.println("Respondendo pesquisa de feedback...");
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEscola() { return escola; }
    public void setEscola(String escola) { this.escola = escola; }
}