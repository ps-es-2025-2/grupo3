package model;

public class Psicologo extends Usuario {
    private String crp;
    private String especialidade;
    private Integer experiencia;

    public Psicologo(Long id, String nome, String email, String senha, String crp) {
        super(id, nome, email, senha);
        this.crp = crp;
    }

    public void analisarAluno(Aluno aluno) {
        System.out.println("Analisando aluno: " + aluno.getNome());
    }

    public void gerarLaudo(Aluno aluno) {
        System.out.println("Gerando laudo para: " + aluno.getNome());
    }

    public void agendarConsulta() {
        System.out.println("Psicólogo agendando consulta...");
    }

    public void realizarConsulta() {
        System.out.println("Realizando consulta...");
    }
    
    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }
}