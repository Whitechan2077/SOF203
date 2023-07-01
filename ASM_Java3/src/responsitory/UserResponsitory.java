/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.util.LinkedList;
import model.User;
import java.sql.*;

/**
 *
 * @author buidu
 */
public class UserResponsitory {


    public LinkedList<User> getUser() throws SQLException {
        ResultSet rs;
        LinkedList<User> listUser;
        try (Connection conn = ConnectDB.getConnection()) {
            try (Statement stm = conn.createStatement()) {
                rs = stm.executeQuery("SELECT * FROM USERS");
                listUser = new LinkedList<>();
                while (rs.next()) {
                    listUser.add(new User(rs.getString("Username"), rs.getString("Password"), rs.getInt("role")));
                }
            }
        }
        rs.close();
        return listUser;
    }
    public void addUser(User u) throws SQLException {
        CallableStatement cstm;
        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "{CALL p_InsertUsers(?,?,?)}";
            cstm = conn.prepareCall(sql);
            cstm.setString(1, u.getUsername());
            cstm.setString(2, u.getPassword());
            cstm.setInt(3, u.getRole());
            cstm.execute();
        }
        cstm.close();
        cstm.close();
    }
}
