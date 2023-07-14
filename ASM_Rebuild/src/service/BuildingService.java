/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.LinkedList;
import model.Classroom;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataBaseConnection;
/**
 *
 * @author buidu
 */
public class BuildingService {
    public LinkedList<Classroom> getAllBuidingDetails(){
           LinkedList<Classroom> listClassRom = new LinkedList<>();
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("SELECT * FROM  dbo.RomDetails()");
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                listClassRom.add(new Classroom(rs.getInt("idPhong"),rs.getInt("soPhong"),rs.getInt("idToa"),rs.getString("maToa")));
            }
            conn.close();
            cstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClassRom;
    }
}
