/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class Conexao {

    // criando as variaveis de conexao
    private static Connection conexao = null;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5433/agenda";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConexao() {
        if (conexao != null) {
            return conexao;
        }

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;

    }
}
