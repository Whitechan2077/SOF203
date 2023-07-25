/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClassRoom;
import utilities.DatabaseConnection;
/**
 *
 * @author buidu
 */
public class ClassRoomService {
    public LinkedList<ClassRoom> getRooms(int id){
        LinkedList<ClassRoom> listClassRoom = new LinkedList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("""
        SELECT RomDetails.idPhong,RomDetails.tenPhong,RomDetails.idToa,RomDetails.maToa,RomDetails.soPhong,RomDetails.maToa
                		FROM  dbo.RomDetails() LEFT JOIN lopHoc ON lopHoc.idPhong = RomDetails.idPhong 
                		where lopHoc.idLop is null ANd RomDetails.idToa =?""");
            cstm.setInt(1, id);
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                listClassRoom.add(new ClassRoom(rs.getInt("idPhong"),rs.getInt("soPhong"),rs.getInt("idToa"),rs.getString("maToa")));
            }
            conn.close();
            cstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassRoomService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClassRoom;
    }
}
