/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.LinkedList;
import model.Major;
import utilities.DatabaseConnection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class MajorService {
    public LinkedList<Major> getAllMajor(){
        LinkedList<Major> listMajor = new LinkedList<>();
        try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DatabaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("SELECT * FROM Chuyen_Nganh");
                while(rs.next()){
                    listMajor.add(new Major(rs.getInt("idNganh"),rs.getString("tenNganh"),rs.getString("maNganh")));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMajor;
    }
    public Map<Integer,String> getMapMajor(){
        Map<Integer,String> MapMajor = new HashMap<>();
       try {
            Statement stm;
            ResultSet rs;
            try (Connection conn = DatabaseConnection.getConnection()) {
                stm = conn.createStatement();
                rs = stm.executeQuery("SELECT * FROM Chuyen_Nganh");
                while(rs.next()){
                    MapMajor.put(rs.getInt("idNganh"),rs.getString("tenNganh"));
                }
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return MapMajor;
    }
    
    public void inputMajor(Major o){
        try {
            Connection conn = DatabaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertNganh (?,?)}");
            cstm.setString(1,o.getMajorCode());
            cstm.setString(2, o.getMajornName());
            cstm.execute();
            conn.close();
            cstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
