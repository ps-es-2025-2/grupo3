package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Repositorio;
import model.Questionario;
import model.Laudo;
import model.Aluno;
import model.Psicologo;
import java.util.List;

public class RepositorioTest {

    @Test
    public void testAdicionarERecuperarQuestionario() {
        // Preparação
        Questionario q = new Questionario(99L, "Questionário de Teste Repo");
        
        // Ação
        Repositorio.adicionarQuestionario(q);
        
        // Verificação
        List<Questionario> lista = Repositorio.getQuestionarios();
        assertTrue(lista.contains(q));
    }

    @Test
    public void testFiltrarLaudosDoAluno() {
        Aluno aluno1 = new Aluno(1L, "João", "joao@teste.com", "123", "000");
        Aluno aluno2 = new Aluno(2L, "Maria", "maria@teste.com", "123", "111");
        Psicologo psi = new Psicologo(10L, "Psi", "psi@teste.com", "123", "CRP");
        
        Laudo laudoJoao = new Laudo(50L, aluno1, psi);
        Laudo laudoMaria = new Laudo(51L, aluno2, psi);
        
        Repositorio.adicionarLaudo(laudoJoao);
        Repositorio.adicionarLaudo(laudoMaria);
        
        List<Laudo> laudosDoJoao = Repositorio.getLaudosDoAluno(1L);
        
        boolean achou = false;
        for(Laudo l : laudosDoJoao) {
            if(l.equals(laudoJoao)) achou = true;
        }
        assertTrue(achou); 
        
        boolean achouMaria = false;
        for(Laudo l : laudosDoJoao) {
            if(l.equals(laudoMaria)) achouMaria = true;
        }
        assertFalse(achouMaria, "Não deveria vir laudos da Maria na busca do João");
    }
}