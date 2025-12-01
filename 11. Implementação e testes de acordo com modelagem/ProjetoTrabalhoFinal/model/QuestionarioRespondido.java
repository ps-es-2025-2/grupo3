package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QuestionarioRespondido {
    private Long id;
    private Aluno aluno;
    private Questionario questionario;
    private Date dataRealizacao;
    
    // Mapa: Enunciado da Pergunta -> Resposta do Aluno
    private Map<String, String> respostasDetalhadas; 
    
    // Área do Psicólogo
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

    // Getters
    public Aluno getAluno() { return aluno; }
    public Questionario getQuestionario() { return questionario; }
    public Map<String, String> getRespostasDetalhadas() { return respostasDetalhadas; }
    public String getFeedbackPsicologo() { return feedbackPsicologo; }
    public boolean isAvaliado() { return avaliado; }
    
    // Importante para aparecer bonito na lista visual do JavaFX
    @Override
    public String toString() {
        return aluno.getNome() + " - " + questionario.getTitulo();
    }
}