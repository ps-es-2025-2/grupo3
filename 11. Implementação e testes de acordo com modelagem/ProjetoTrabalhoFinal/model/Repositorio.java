package model;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    
    private static List<Laudo> laudos = new ArrayList<>();
    private static List<QuestionarioRespondido> questionariosRespondidos = new ArrayList<>();
    private static List<Questionario> questionarios = new ArrayList<>();

    public static void adicionarQuestionario(Questionario q) {
        questionarios.add(q);
    }

    public static List<Questionario> getQuestionarios() {
        return questionarios;
    }
    
    public static void adicionarLaudo(Laudo l) { laudos.add(l); }
    
    public static List<Laudo> getLaudosDoAluno(Long alunoId) {
        List<Laudo> filtrados = new ArrayList<>();
        for (Laudo l : laudos) {
             filtrados.add(l); 
        }
        return filtrados;
    }

    public static boolean verificarSeJaRespondeu(Long idAluno) {
        for (QuestionarioRespondido qr : questionariosRespondidos) {
            if (qr.getAluno().getId().equals(idAluno)) {
            }
        }
        return false;
    }
    
    public static void adicionarQuestionarioRespondido(QuestionarioRespondido qr) {
        questionariosRespondidos.add(qr);
    }

    public static List<QuestionarioRespondido> getQuestionariosPendentes() {
        List<QuestionarioRespondido> pendentes = new ArrayList<>();
        for (QuestionarioRespondido qr : questionariosRespondidos) {
            if (!qr.isAvaliado()) {
                pendentes.add(qr);
            }
        }
        return pendentes;
    }
    
 
    public static void inicializarMock() {
        // Se necessário, crie dados falsos aqui
    }
}