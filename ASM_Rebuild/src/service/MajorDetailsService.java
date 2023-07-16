/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataBaseConnection;
import model.MajorDetails;
/**
 *
 * @author buidu
 */
public class MajorDetailsService {
    public LinkedList< MajorDetails> getMajorDetails(int id){
        LinkedList< MajorDetails> listMajorDetails = new LinkedList<>();
        try {
            try (Connection conn = DataBaseConnection.getConnection(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM dbo.GetChuyenNganhById("+id+")")) {
                while (rs.next()) {
                    listMajorDetails.add(new MajorDetails(rs.getInt("idNganhHep"),rs.getString("maNganh"),rs.getString("tenNganhHep"),rs.getInt("idNganhHep"),rs.getString("tenNganh"),rs.getString("maNganh")));
                }
            }          
        } catch (SQLException ex) {
            Logger.getLogger(MajorDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMajorDetails;
    }
    public void insertMajorDetails(MajorDetails o){
        try {
            Connection conn  = DataBaseConnection.getConnection();
            CallableStatement csmt = conn.prepareCall("{CALL p_insertNganhHep(?,?,?)}");
            csmt.setInt(1, o.getMajorid());
            csmt.setString(2,o.getMajorDetailsCode());
            csmt.setString(3,o.getMajorDetailsName());
            csmt.execute();
            conn.close();
            csmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Map<String,Integer> getMapMajorDetails(int id){
        Map<String,Integer> MapMajor = new HashMap<>();
       try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DataBaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("SELECT * FROM Nganh_Hep WHERE idNganh = "+id);
                while(rs.next()){
                    MapMajor.put(rs.getString("tenNganhHep"),rs.getInt("idNganhHep"));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return MapMajor;
    }
}
