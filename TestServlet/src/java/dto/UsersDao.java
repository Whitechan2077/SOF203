/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;
import model.Users;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class UsersDao {
    public static Users getUser(String username,String password){
        Users user = new Users();
        try {
             Connection conn = null;
             conn = DBConnections.getConnection();
             PreparedStatement pstm = conn.prepareCall("SELECT * FROM USERS WHERE Username like ? AND Password like ?");
             pstm.setString(1, username);
             pstm.setString(2,password);
             ResultSet rs = pstm.executeQuery();
             while (rs.next()) {                
                user = new Users(rs.getString("Username"), rs.getString("Password"),rs.getInt("role"));
            }
             conn.close();
             pstm.close();
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
