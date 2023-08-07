/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utilities.DatabaseConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author buidu
 */
public class BookService {

    public LinkedList<Book> loadData() {
        LinkedList<Book> listBook = new LinkedList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("""
           select * from SACH """);
            while (rs.next()) {
                listBook.add(new Book(rs.getString("Masach"), rs.getString("TenSach"), rs.getString("NXB"), rs.getInt("Sotrang"), rs.getInt("SoLuong"), rs.getDouble("Giatien"), rs.getDate("NgayNhap"), rs.getString("vitridat"), rs.getString("MaTheLoai")));
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBook;
    }

    public void insertBook(Book o) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement cstm = conn.prepareCall("""
           INSERT INTO SACH(Masach,TenSach,Sotrang,Giatien)
              VALUES(?,?,?,?);                                           """);
        cstm.setString(1,o.getBookCode());
        cstm.setString(2,o.getBookName());
        cstm.setInt(3, o.getNumberOfPages());
        cstm.setDouble(4, o.getPrice());
        cstm.executeUpdate();
        conn.close();
        cstm.close();
    }
    public void updateBook(Book o,String code) throws SQLException{
           Connection conn = DatabaseConnection.getConnection();
        CallableStatement cstm = conn.prepareCall("""
        Update SACH set Masach = ?, TenSach = ?,Sotrang = ?,Giatien = ?
           	WHERE Masach = ?                                           """);
        cstm.setString(1,o.getBookCode());
        cstm.setString(2,o.getBookName());
        cstm.setInt(3, o.getNumberOfPages());
        cstm.setDouble(4, o.getPrice());
        cstm.setString(5,code);
        cstm.executeUpdate();
        conn.close();
        cstm.close();
    }
   public void deleteBook(String code) throws SQLException{
           Connection conn = DatabaseConnection.getConnection();
        CallableStatement cstm = conn.prepareCall("""
             DELETE FROM SACH WHERE Masach = ?                                         """);
        cstm.setString(1,code);
        cstm.executeUpdate();
        conn.close();
        cstm.close();
    }
}
