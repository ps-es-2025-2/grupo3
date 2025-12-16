package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/psicologia_escolar";
    private static final String USER = "postgres";
    private static final String PASS = "admin"; 

    public static Connection getConexao() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}