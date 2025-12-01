package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Aluno;

public class UsuarioTest {

    @Test
    public void testLoginSucesso() {
        Aluno aluno = new Aluno(1L, "Teste", "teste@email.com", "senha123", "CPF");
        
        assertTrue(aluno.login("teste@email.com", "senha123"));
    }

    @Test
    public void testLoginFalhaSenha() {
        Aluno aluno = new Aluno(1L, "Teste", "teste@email.com", "senha123", "CPF");
        
        assertFalse(aluno.login("teste@email.com", "senhaErrada"));
    }
    
    @Test
    public void testLoginFalhaEmail() {
        Aluno aluno = new Aluno(1L, "Teste", "teste@email.com", "senha123", "CPF");
        
        assertFalse(aluno.login("errado@email.com", "senha123"));
    }
}