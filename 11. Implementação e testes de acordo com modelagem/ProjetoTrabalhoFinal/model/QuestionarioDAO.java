package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionarioDAO {

    public void salvar(Questionario q) {
        String sqlQuestionario = "INSERT INTO questionario (titulo, descricao, ativo, data_criacao) VALUES (?, ?, ?, ?)";
        String sqlPergunta = "INSERT INTO pergunta (enunciado, tipo, obrigatoria, ordem, questionario_id) VALUES (?, ?, ?, ?, ?)";
        String sqlOpcao = "INSERT INTO opcao (texto, pergunta_id) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtQ = null;
        PreparedStatement stmtP = null;
        PreparedStatement stmtO = null;

        try {
            conn = ConexaoBD.getConexao();
            conn.setAutoCommit(false);

            stmtQ = conn.prepareStatement(sqlQuestionario, Statement.RETURN_GENERATED_KEYS);
            stmtQ.setString(1, q.getTitulo());
            stmtQ.setString(2, q.getDescricao());
            stmtQ.setBoolean(3, true);
            stmtQ.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmtQ.executeUpdate();

            Long idQuestionarioGerado = null;
            ResultSet rsQ = stmtQ.getGeneratedKeys();
            if (rsQ.next()) {
                idQuestionarioGerado = rsQ.getLong(1);
                q.setId(idQuestionarioGerado); 
            }

            stmtP = conn.prepareStatement(sqlPergunta, Statement.RETURN_GENERATED_KEYS);
            stmtO = conn.prepareStatement(sqlOpcao);

            List<Pergunta> perguntas = q.getPerguntas(); 
            if (perguntas != null) {
                int ordem = 1;
                for (Pergunta p : perguntas) {
                    stmtP.setString(1, p.getEnunciado()); 
                    stmtP.setString(2, "MULTIPLA");
                    stmtP.setBoolean(3, true);
                    stmtP.setInt(4, ordem++);
                    stmtP.setLong(5, idQuestionarioGerado);
                    stmtP.executeUpdate();

                    ResultSet rsP = stmtP.getGeneratedKeys();
                    Long idPerguntaGerada = null;
                    if (rsP.next()) {
                        idPerguntaGerada = rsP.getLong(1);
                    }

                    List<String> opcoes = p.obterOpcoesResposta(); //
                    if (opcoes != null) {
                        for (String textoOpcao : opcoes) {
                            stmtO.setString(1, textoOpcao);
                            stmtO.setLong(2, idPerguntaGerada);
                            stmtO.addBatch();
                        }
                        stmtO.executeBatch();
                    }
                }
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try {
                if (stmtO != null) stmtO.close();
                if (stmtP != null) stmtP.close();
                if (stmtQ != null) stmtQ.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public List<Questionario> listarTodos() {
        List<Questionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM questionario ORDER BY id";

        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String titulo = rs.getString("titulo");

                Questionario q = new Questionario(id, titulo);

                carregarPerguntas(q, conn);
                
                lista.add(q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Questionario buscarPorId(Long id) {
        String sql = "SELECT * FROM questionario WHERE id = ?";
        Questionario q = null;

        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String titulo = rs.getString("titulo");
                q = new Questionario(id, titulo);
    
                carregarPerguntas(q, conn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }
    
    private void carregarPerguntas(Questionario q, Connection conn) throws SQLException {
        String sql = "SELECT * FROM pergunta WHERE questionario_id = ? ORDER BY ordem";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, 1L);
            stmt.setLong(1, q.getId()); 
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Long idPerg = rs.getLong("id");
                String enunciado = rs.getString("enunciado");
                String tipo = rs.getString("tipo");
                
                Pergunta p = new Pergunta(idPerg, enunciado, tipo); 
                
                carregarOpcoes(p, conn);
                
                q.adicionarPergunta(p); 
            }
        }
    }

    private void carregarOpcoes(Pergunta p, Connection conn) throws SQLException {
        String sql = "SELECT texto FROM opcao WHERE pergunta_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, p.getId()); 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.adicionarOpcaoResposta(rs.getString("texto")); 
            }
        }
    }
}