package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaudoDAO {

    public void salvar(Laudo laudo) {
        String sql = "INSERT INTO laudo (conteudo, aluno_id, psicologo_id) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, laudo.getConteudo());
            stmt.setLong(2, laudo.getAlunoId()); 
            stmt.setLong(3, laudo.getPsicologoId()); 
            
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Laudo> listarPorAluno(Long alunoId) {
        List<Laudo> laudos = new ArrayList<>();
        String sql = "SELECT * FROM laudo WHERE aluno_id = ?";
        
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, alunoId);
            ResultSet rs = stmt.executeQuery();
            
            AlunoDAO alunoDAO = new AlunoDAO();
            PsicologoDAO psiDAO = new PsicologoDAO(); 

            while (rs.next()) {
                Aluno a = alunoDAO.buscarPorId(rs.getLong("aluno_id"));
                Psicologo p = psiDAO.buscarPorId(rs.getLong("psicologo_id"));

                Laudo l = new Laudo(rs.getLong("id"), a, p);
                l.setConteudo(rs.getString("conteudo"));
                laudos.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laudos;
    }
}