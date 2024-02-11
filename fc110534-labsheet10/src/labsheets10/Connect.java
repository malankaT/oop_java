/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheets10;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
/**
 *
 * @author  Malanka Tharula
 */
public class Connect {
        public static Connection getConnection() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/empmasters.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " +e.getMessage());
        }
        return conn;
    }
}
