/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.LinkedList;
import utilities.DataBaseConnection;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
/**
 *
 * @author buidu
 */
public class UserService {
     private static User currentUser;

    public static void setCurrentUser(User currentUser) {
        UserService.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public LinkedList<User> getAllUser(){
            LinkedList<User> listUser = new LinkedList<>();
        try {
            Connection conn = DataBaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {                
                listUser.add(new User(rs.getInt("userId")
                        ,rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("idSinhVien")
                        ,rs.getInt("idGiangVien"),
                        rs.getInt("idCanBo")));
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }
    public User getUser (String username,String pasword){
        User user = new User();
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("SELECT * FROM Users WHERE username like ? AND password like ?");
            cstm.setString(1, username);
            cstm.setString(2, pasword);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {                
                user.setId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setStudentId(rs.getInt("idSinhVien"));
                user.setLectureId(rs.getInt("idGiangVien"));
                user.setMaId(rs.getInt("idCanBo"));
            }
            conn.close();
            cstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
