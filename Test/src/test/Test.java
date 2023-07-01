/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class Test {
    private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=test1;user=sa;password=06122004;encrypt = false;";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Done");
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Fail");

        }
        return conn;
    }
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM GIANG_VIEN");
            while (rs.next()) {                
                System.out.println(rs.getString("tenGiangVien"));
                System.out.println(rs.getString("SDT"));
            }
            conn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
}
