package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email, senha, cpf) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getSenha());
            stmt.setString(4, aluno.getCpf());
            
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getLong(1));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Aluno> listarTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno ORDER BY nome";

        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cpf")
                );
                alunos.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public Aluno buscarPorId(Long id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Aluno(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}