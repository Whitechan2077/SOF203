/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class testConnect {
        private final static String url ="jdbc:sqlserver://localhost8080:1433;databaseName=test1;user=sa;password=06122004;encrypt=false;";
        private static final String con = "jdbc:sqlserver://:1433;databaseName=test1;user=sa;password=06122004;encrypt = false;";

        public static Connection getConnection(){
         Connection conn =null;
         try {
             conn = DriverManager.getConnection(url);
             System.out.println("done");
         }catch (SQLException ex){
               Logger.getLogger(testConnect.class.getName()).log(Level.SEVERE, null, ex);

         }
    return conn;
     }
    public static void main(String[] args) {
        getConnection();
    }
}
