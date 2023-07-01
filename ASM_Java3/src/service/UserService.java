/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.SQLException;
import java.util.LinkedList;
import model.User;
import responsitory.ConnectDB;
import responsitory.UserResponsitory;
/**
 *
 * @author buidu
 */
public class UserService {
    private UserResponsitory urs = new UserResponsitory();
    
    public LinkedList<User> getUsers() throws SQLException{
        return urs.getUser();
    }
    public void addUser(User u) throws SQLException{
        urs.addUser(u);
    }
}
