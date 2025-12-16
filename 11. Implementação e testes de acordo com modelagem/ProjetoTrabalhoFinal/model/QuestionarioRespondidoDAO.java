package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionarioRespondidoDAO {

    public void salvar(QuestionarioRespondido qr) {
        String sqlQR = "INSERT INTO questionario_respondido (aluno_id, questionario_id, data_realizacao, feedback_psicologo, avaliado) VALUES (?, ?, ?, ?, ?)";
        String sqlDetalhe = "INSERT INTO resposta_detalhada (questionario_respondido_id, enunciado, resposta) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtQR = null;
        PreparedStatement stmtDetalhe = null;

        try {
            conn = ConexaoBD.getConexao();
            conn.setAutoCommit(false); 

            stmtQR = conn.prepareStatement(sqlQR, Statement.RETURN_GENERATED_KEYS);

            stmtQR.setLong(1, qr.getAluno().getId());
            stmtQR.setLong(2, qr.getQuestionario().getId());
            stmtQR.setTimestamp(3, new Timestamp(qr.getDataRealizacao().getTime()));
            stmtQR.setString(4, qr.getFeedbackPsicologo());
            stmtQR.setBoolean(5, qr.isAvaliado());
            stmtQR.executeUpdate();

            ResultSet rs = stmtQR.getGeneratedKeys();
            Long idGerado = null;
            if (rs.next()) {
                idGerado = rs.getLong(1);
                qr.setId(idGerado);
            }

            stmtDetalhe = conn.prepareStatement(sqlDetalhe);
            Map<String, String> map = qr.getRespostasDetalhadas();
            
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stmtDetalhe.setLong(1, idGerado);
                stmtDetalhe.setString(2, entry.getKey());
                stmtDetalhe.setString(3, entry.getValue());
                stmtDetalhe.addBatch();
            }
            stmtDetalhe.executeBatch();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try {
                if (stmtQR != null) stmtQR.close();
                if (stmtDetalhe != null) stmtDetalhe.close();
                if (conn != null) { conn.setAutoCommit(true); conn.close(); }
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }


    public boolean verificarSeAlunoRespondeu(Long idAluno) {
        String sql = "SELECT COUNT(*) FROM questionario_respondido WHERE aluno_id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, idAluno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<QuestionarioRespondido> listarPendentes() {
        List<QuestionarioRespondido> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM questionario_respondido WHERE avaliado = false";

        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            AlunoDAO alunoDAO = new AlunoDAO();
            QuestionarioDAO questionarioDAO = new QuestionarioDAO();

            while (rs.next()) {
                Long idQR = rs.getLong("id");
                Long alunoId = rs.getLong("aluno_id");
                Long questId = rs.getLong("questionario_id");
                
                Aluno aluno = alunoDAO.buscarPorId(alunoId);
                Questionario questionario = questionarioDAO.buscarPorId(questId); 
                
                if (aluno != null && questionario != null) {
                    QuestionarioRespondido qr = new QuestionarioRespondido(aluno, questionario);
                    qr.setId(idQR);
                    qr.setDataRealizacao(rs.getTimestamp("data_realizacao"));
                    qr.setAvaliado(rs.getBoolean("avaliado"));
                    qr.setFeedbackPsicologo(rs.getString("feedback_psicologo"));
                    
                    carregarRespostasDetalhadas(qr, conn);
                    
                    lista.add(qr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private void carregarRespostasDetalhadas(QuestionarioRespondido qr, Connection conn) throws SQLException {
        String sql = "SELECT enunciado, resposta FROM resposta_detalhada WHERE questionario_respondido_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, qr.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                qr.adicionarResposta(rs.getString("enunciado"), rs.getString("resposta"));
            }
        }
    }
}