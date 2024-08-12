/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheets10;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Statement;
/*import any else if necessary */
/**
 *
 * @author  Malanka Tharula
 */
public class CreateTables {
        public static void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS students (\n" +
                     " index_no integer PRIMARY KEY,\n" +
                     " name text ,\n" +
                     " subject1 text ,\n" +
                     " subject2 text ,\n" +
                     " subject3 text ,\n" +
                     " GPA double \n" +
                     ")";

        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Student table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating student table: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }
}
