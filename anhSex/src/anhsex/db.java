/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhsex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buidu
 */
public class db {
         private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=anhJav;user=sa;password=06122004;encrypt=false";
     public static Connection getConnection(){
         Connection conn = null;
         try {           
             conn = DriverManager.getConnection(connectionUrl);
         } catch (SQLException ex) {
             Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);            
         }
          return conn;
     }
    public static void main(String[] args) {
        getConnection();
    }
}
