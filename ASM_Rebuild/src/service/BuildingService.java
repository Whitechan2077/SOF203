/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.LinkedList;
import model.ClassRoom;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataBaseConnection;
import model.Building;
/**
 *
 * @author buidu
 */
public class BuildingService {
    public LinkedList<ClassRoom> getAllBuidingDetails(){
           LinkedList<ClassRoom> listClassRom = new LinkedList<>();
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("SELECT * FROM  dbo.RomDetails()");
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                listClassRom.add(new ClassRoom(rs.getInt("idPhong"),rs.getInt("soPhong"),rs.getInt("idToa"),rs.getString("maToa")));
            }
            conn.close();
            cstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClassRom;
    }
    public void insertNewBuilding(Building o){
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("EXEC p_insertBuilding ?");
            cstm.setString(1,o.getBuilingCode());
            cstm.execute();
            conn.close();
            cstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public LinkedList<Building> getBuildingIformations(){
           LinkedList<Building> listBuilding = new LinkedList<>();
        try {
            Connection conn = DataBaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM toaNha");
            while(rs.next()){
              listBuilding.add(new Building(rs.getInt("idToa"),rs.getString("maToa")));
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBuilding;
    }
    
    public void insertClassRoom(ClassRoom o){
        try {
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertRoom (?,?)}");
            cstm.setInt(1,o.getIdBuiding());
            cstm.setInt(2, o.getRommcode());
            cstm.execute();
            conn.close();
            cstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }          
}
