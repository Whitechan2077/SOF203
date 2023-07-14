/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhsex;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class Service {
    public void addImg(byte[] img){
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
                 INSERT INTO anhSex
                         VALUES(?)
                                                      """);
            pstm.setBytes(1, img);
            pstm.execute();
            conn.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
