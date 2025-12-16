package model;

import java.util.List;
import java.util.ArrayList;

public class Repositorio {
    
    private static QuestionarioDAO questionarioDAO = new QuestionarioDAO();
    private static LaudoDAO laudoDAO = new LaudoDAO();
    private static QuestionarioRespondidoDAO qrDAO = new QuestionarioRespondidoDAO();
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static AlunoDAO alunoDAO = new AlunoDAO();
    private static PsicologoDAO psicologoDAO = new PsicologoDAO();

    public static Usuario autenticarUsuario(String email, String senha) {
        return usuarioDAO.autenticar(email, senha);
    }
    
        public static void cadastrarAluno(Aluno aluno) {
        try {
            alunoDAO.salvar(aluno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void cadastrarPsicologo(Psicologo psi) {
        try {
            psicologoDAO.salvar(psi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List<Aluno> getAlunos() {
        return alunoDAO.listarTodos();
    }

    public static void adicionarQuestionario(Questionario q) {
        questionarioDAO.salvar(q);
    }

    public static List<Questionario> getQuestionarios() {
        return questionarioDAO.listarTodos();
    }

    public static void adicionarLaudo(Laudo l) {
        laudoDAO.salvar(l);
    }
    
    public static List<Laudo> getLaudosDoAluno(Long alunoId) {
        return laudoDAO.listarPorAluno(alunoId);
    }

    public static boolean verificarSeJaRespondeu(Long idAluno) {
        return qrDAO.verificarSeAlunoRespondeu(idAluno);
    }
    
    public static void adicionarQuestionarioRespondido(QuestionarioRespondido qr) {
        qrDAO.salvar(qr);
    }

    public static List<QuestionarioRespondido> getQuestionariosPendentes() {
        return qrDAO.listarPendentes();
    }

    public static void inicializarMock() {
        // Este método pode ficar vazio ou ser removido, pois os dados 
        // agora persistem na base de dados PostgreSQL e não se perdem ao fechar o programa.
        
        // Opcional: Pode colocar aqui uma verificação se a BD está vazia 
        // e criar um admin ou questionário padrão se necessário.
    }
}