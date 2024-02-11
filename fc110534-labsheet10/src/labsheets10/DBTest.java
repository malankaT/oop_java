/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheets10;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author  Malanka Tharula
 */
public class DBTest {
        public static void insert(int index_no,String name, String subject1, String subject2, String subject3, double GPA) {
        String sql = "INSERT INTO students(index_no, name, subject1, subject2, subject3, GPA) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = Connect.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, index_no);
            pstmt.setString(2, name);
            pstmt.setString(3, subject1);
            pstmt.setString(4, subject2);
            pstmt.setString(5, subject3);
            pstmt.setDouble(6, GPA);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        insert(1234, "malanka","physics","c.maths","chemistry",3.0);
        insert(4321, "chamodi","physics","c.maths","chemistry",3.2);
        

        // Retrieve Data
        String sql = "SELECT * FROM Students";
        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("index") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("subject1") + "\t" +
                        rs.getString("subject2") + "\t" +
                        rs.getString("subject3") + "\t" +
                        rs.getDouble("GPA"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student details: " + e.getMessage());
        }
    }
}
