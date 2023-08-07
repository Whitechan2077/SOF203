/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.LinkedList;
import utilities.DatabaseConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
/**
 *
 * @author buidu
 */
public class EmployeeService {
    public LinkedList<Employee> listEmployee(){
        LinkedList<Employee> listEmployee = new LinkedList<>();
        try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DatabaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("select * from NHANVIEN");
                while (rs.next()) {
                    listEmployee.add(new Employee(rs.getString("ID"), rs.getString("HoTen"),rs.getDouble("Luong"), rs.getString("TrinhDo")));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return listEmployee;
    }
    public void insert(Employee o) throws SQLException{
        PreparedStatement pstm;
        try (Connection conn = DatabaseConnection.getConnection()) {
            pstm = conn.prepareCall("""
                                     insert into NHANVIEN(HoTen,luong,TrinhDo)
                                        	VALUES(?,?,?);
                                    """);
            pstm.setString(1,o.getName());
            pstm.setDouble(2, o.getSalary());
            pstm.setString(3,o.getEducation());
            pstm.executeUpdate();
        }
        pstm.close();
    }
    public void update(Employee o) throws SQLException{
            PreparedStatement pstm;
        try (Connection conn = DatabaseConnection.getConnection()) {
            pstm = conn.prepareCall("""
                                    Update NHANVIEN SET HoTen = ?,luong = ?,TrinhDo=? where ID = ?;
                                        """);
            pstm.setString(1,o.getName());
            pstm.setDouble(2, o.getSalary());
            pstm.setString(3,o.getEducation());
            pstm.setString(4,o.getId());
            pstm.executeUpdate();
        }
        pstm.close();
    }
  public void delete(String id) throws SQLException{
      PreparedStatement pstm;
        try (Connection conn = DatabaseConnection.getConnection()) {
            pstm = conn.prepareCall("""
                                    Delete from NHANVIEN where ID = ?
                                        """);
            pstm.setString(1,id);
            pstm.executeUpdate();
        }
        pstm.close();
    }
}
