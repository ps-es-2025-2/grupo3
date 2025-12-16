package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsicologoDAO {
    
    public void salvar(Psicologo psicologo) {
        String sql = "INSERT INTO psicologo (nome, email, senha, crp) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getEmail());
            stmt.setString(3, psicologo.getSenha());
            stmt.setString(4, psicologo.getCrp());
            
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                psicologo.setId(rs.getLong(1));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Psicologo buscarPorId(Long id) {
        String sql = "SELECT * FROM psicologo WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Psicologo(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("crp")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}