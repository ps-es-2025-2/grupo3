package model;

import java.util.Date;

public class Laudo {
    private Long id;
    private Date dataGeracao;
    private String conteudo;
    private String arquivoPDF;
    private String status;
    private Long alunoId;
    private Long psicologoId;
    
    // Associação com GeradorPDF
    private GeradorPDF geradorPDF;

    public Laudo(Long id, Aluno aluno, Psicologo psicologo) {
        this.id = id;
        this.alunoId = aluno.getId();
        this.psicologoId = psicologo.getId();
        this.dataGeracao = new Date();
        this.geradorPDF = new GeradorPDF();
    }

    public void gerarPDF() {
        this.arquivoPDF = geradorPDF.gerarPDFLaudo(this) ? "caminho/arquivo.pdf" : null;
    }

    public void enviarLaudo() {
        System.out.println("Enviando laudo para o aluno...");
    }
    
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}