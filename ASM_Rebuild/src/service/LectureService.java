/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.LinkedList;
import model.Lecture;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataBaseConnection;
/**
 *
 * @author buidu
 */
public class LectureService {
    public LinkedList<Lecture> getAllLectureData(){
        LinkedList<Lecture> listLecture  = new LinkedList<>();
        try {
            Connection conn = DataBaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from dbo.LectureData()");
            while (rs.next()) {                
                listLecture.add(new Lecture(rs.getInt("idGiangVien"),rs.getString("tenGiangVien"),rs.getString("tenNganh"),rs.getString("sdt"),rs.getByte("gioiTinh"),rs.getString("diaChi"),rs.getBytes("hinhAnh"),rs.getString("email")));
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LectureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLecture;
    }
    
        public void insertStudent(Lecture o){
        try {          
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertLecture (?,?,?,?,?,?,?)}");
            cstm.setString(1, o.getLectureName());
            cstm.setInt(2, o.getIdMajor());
            cstm.setString(4, o.getEmail());
            cstm.setString(3, o.getPhoneNum());
            cstm.setByte(5,o.getGender());
            cstm.setBytes(6, o.getImg());
            cstm.setString(7, o.getAddress());  
            System.out.println(o.toString());
            cstm.execute();
            cstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
