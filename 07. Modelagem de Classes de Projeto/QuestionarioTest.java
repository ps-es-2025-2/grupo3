package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Questionario;
import model.Pergunta;
import java.util.List;

public class QuestionarioTest {

    private Questionario questionario;

    @BeforeEach
    public void setUp() {
        questionario = new Questionario(1L, "Teste de Ansiedade");
    }

    @Test
    public void testCriacaoQuestionario() {
        assertEquals("Teste de Ansiedade", questionario.getTitulo());
        assertNotNull(questionario.getPerguntas());
        assertTrue(questionario.getPerguntas().isEmpty());
    }

    @Test
    public void testAdicionarPergunta() {
        Pergunta p = new Pergunta(10L, "Você dorme bem?", "MULTIPLA");
        p.adicionarOpcaoResposta("Sim");
        p.adicionarOpcaoResposta("Não");

        questionario.adicionarPergunta(p);

        List<Pergunta> lista = questionario.getPerguntas();
        assertEquals(1, lista.size());
        assertEquals("Você dorme bem?", lista.get(0).getEnunciado());
    }
    
    @Test
    public void testRemoverPergunta() {
        Pergunta p = new Pergunta(10L, "Pergunta Temp", "TEXTO");
        questionario.adicionarPergunta(p);
        assertEquals(1, questionario.getPerguntas().size());
        
        questionario.removerPergunta(p);
        assertEquals(0, questionario.getPerguntas().size());
    }
}