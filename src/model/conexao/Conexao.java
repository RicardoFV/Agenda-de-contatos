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

    private static Connection conexao = null;

    public static Connection getConexao() {
        if (conexao != null) {
            return conexao;
        }

        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5433/agenda";
            String user = "postgres";
            String password = "1234";
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;

    }
}
