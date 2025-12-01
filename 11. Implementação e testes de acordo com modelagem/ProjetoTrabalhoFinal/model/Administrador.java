package model;

public class Administrador extends Usuario {
    private String nivelAcesso;

    public Administrador(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.nivelAcesso = "TOTAL";
    }

    public void cadastrarPsicologo(Psicologo p) {
        System.out.println("Psicólogo " + p.getNome() + " cadastrado.");
    }

    public void gerenciarUsuarios() {
        System.out.println("Gerenciando usuários...");
    }

    public void cadastrarQuestionario(Questionario q) {
        System.out.println("Questionário " + q.getTitulo() + " cadastrado.");
    }
    
    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }
}