package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QuestionarioRespondido {
    private Long id;
    private Aluno aluno;
    private Questionario questionario;
    private Date dataRealizacao;
    
    private Map<String, String> respostasDetalhadas; 
    
    private String feedbackPsicologo; 
    private boolean avaliado;

    public QuestionarioRespondido(Aluno aluno, Questionario questionario) {
        this.aluno = aluno;
        this.questionario = questionario;
        this.dataRealizacao = new Date();
        this.respostasDetalhadas = new HashMap<>();
        this.avaliado = false;
        this.feedbackPsicologo = "";
    }

    public void adicionarResposta(String enunciado, String resposta) {
        this.respostasDetalhadas.put(enunciado, resposta);
    }
    
    public void registrarFeedback(String feedback) {
        this.feedbackPsicologo = feedback;
        this.avaliado = true;
    }

    public Aluno getAluno() { return aluno; }
    public Questionario getQuestionario() { return questionario; }
    public Map<String, String> getRespostasDetalhadas() { return respostasDetalhadas; }
    public void setFeedbackPsicologo(String feedback) { this.feedbackPsicologo = feedback; }
    public String getFeedbackPsicologo() { return feedbackPsicologo; }
    public void setAvaliado(boolean avaliado) { this.avaliado = avaliado; }
    public boolean isAvaliado() { return avaliado; }
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setDataRealizacao(Date dataRealizacao) { this.dataRealizacao = dataRealizacao; }
    public Date getDataRealizacao() { return dataRealizacao; }
    
    @Override
    public String toString() {
        return aluno.getNome() + " - " + questionario.getTitulo();
    }
}