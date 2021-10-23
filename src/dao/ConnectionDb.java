/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public final class ConnectionDb {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/evalart_reto";
    private final String userDb = "root";
    private final String passworDb = "";
    
    private static ConnectionDb connection = null;
    
    public static ConnectionDb getInstance() {
        if (connection == null)
            connection = new ConnectionDb();
        
        return connection;
    }
    
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionUrl, userDb, passworDb);
        return conn;
    }
}
