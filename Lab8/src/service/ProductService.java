/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import untilities.DatabaseConnection;
import model.Product;
/**
 *
 * @author buidu
 */
public class ProductService {
    public LinkedList<Product> getAllProdcut() throws SQLException{
           LinkedList<Product> listProduct = new LinkedList<>();
    
            Connection conn = DatabaseConnection.getConnection();
            Statement cstm = conn.createStatement();
            ResultSet rs = cstm.executeQuery("SELECT * FROM Product");
            while(rs.next()){
                listProduct.add(new Product(rs.getString("name"),rs.getInt("quantity"),rs.getString("color"),rs.getDouble("price"),rs.getInt("id")));
            }
            conn.close();
            cstm.close();
            rs.close();
       
        return listProduct;
    }
    public void insertProduct(Product o){
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
            insert into Product (name, quantity, price, color) values(?,?,?,?)""");
            pstm.setString(1,o.getName());
            pstm.setInt(2,o.getQuantity());
            pstm.setDouble(3, o.getPrice());
            pstm.setString(4,o.getColor());
            pstm.executeUpdate();
            conn.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteProduct(int id){
       try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
            DELETE FROM Product WHERE id like ?""");
            pstm.setInt(1, id);
            pstm.executeUpdate();
            conn.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateProduct(Product o,int id){
             try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
            UPDate Product set name = ?,quantity=?,price=?,color=? WHERE id = ?""");
            pstm.setString(1,o.getName());
            pstm.setInt(2,o.getQuantity());
            pstm.setDouble(3, o.getPrice());
            pstm.setString(4,o.getColor());
            pstm.setInt(5,id);
            pstm.executeUpdate();
            conn.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
