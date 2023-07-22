/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Class;
import utilities.DataBaseConnection;
/**
 *
 * @author buidu
 */
public class ClassService {
    public LinkedList<Class> getAllClassData(){
        LinkedList<Class> listClass = new LinkedList<>();
        try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DataBaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("SELECT  * FROM dbo.GetClassData()");
                while(rs.next()){
                    listClass.add(new Class(rs.getInt("idLop"),rs.getString("maLOp"),rs.getInt("idPhong"),rs.getString("tenPhong"),rs.getInt("idNganhHep"),rs.getString("tenNganhHep"),rs.getInt("idNganh"),rs.getString("tenNganh")));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClass;
    }
    public void insertClass(Class o){
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertClass (?,?,?)}");
            cstm.setInt(1, o.getMajorid());
            cstm.setInt(2, o.getMajorDetaisId());
            cstm.setInt(3, o.getRommId());
            cstm.execute();
            cstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public LinkedList<Class> getAllClassDataByMajorDetailsId(int id){
        LinkedList<Class> listClass = new LinkedList<>();
        try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DataBaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("SELECT  * FROM dbo.GetClassData() WHERE GetClassData.idNganhHep = "+id);
                while(rs.next()){
                    listClass.add(new Class(rs.getInt("idLop"),rs.getString("maLOp"),rs.getInt("idPhong"),rs.getString("tenPhong"),rs.getInt("idNganhHep"),rs.getString("tenNganhHep"),rs.getInt("idNganh"),rs.getString("tenNganh")));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClass;
    }
}
