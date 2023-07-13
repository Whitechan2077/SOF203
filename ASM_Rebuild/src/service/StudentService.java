/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.StudentDetail;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataBaseConnection;
import model.Student;
public class StudentService {
    public StudentDetail getStudentDetail(int studentId){
          StudentDetail stu = new StudentDetail();
        try {          
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("""
            SELECT Sinh_Vien.idSinhVien,Nganh_Hep.tenNganhHep,Sinh_Vien.tenSinhVien,Sinh_Vien.gioiTinh,tenNganh,Sinh_Vien.email,Sinh_Vien.diaChi,Sinh_Vien.sdt,Sinh_Vien.hinhAnh
            FROM Sinh_Vien JOIN Nganh_Hep ON Sinh_Vien.idNganhHep = Nganh_Hep.idNganhHep JOIN Chuyen_Nganh on Nganh_Hep.idNganh = Chuyen_Nganh.idNganh WHERE idSinhVien like ?""");
            cstm.setInt(1, studentId);
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                stu.setId(rs.getInt("idSinhVien"));
                stu.setName(rs.getString("tenSinhVien"));
                stu.setGender(rs.getByte("gioiTinh"));
                stu.setEmail(rs.getString("email"));
                stu.setAddress(rs.getString("diaChi"));
                stu.setMajor(rs.getString("tenNganh"));
                stu.setMajorDetail(rs.getString("tennganhHep"));
                stu.setPhoneNum(rs.getString("sdt"));
                stu.setImage(rs.getBytes("hinhAnh"));
            }
            cstm.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }
    public LinkedList<StudentDetail> getAlLStudentDetail(){
          LinkedList<StudentDetail> listStudent = new LinkedList<>();
        try {          
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("SELECT * FROm dbo.GetStudentData()");
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                StudentDetail stu = new StudentDetail();
                stu.setId(rs.getInt("idSinhVien"));
                stu.setName(rs.getString("tenSinhVien"));
                stu.setGender(rs.getByte("gioiTinh"));
                stu.setEmail(rs.getString("email"));
                stu.setAddress(rs.getString("diaChi"));
                stu.setMajor(rs.getString("tenNganh"));
                stu.setMajorDetail(rs.getString("tennganhHep"));
                stu.setPhoneNum(rs.getString("sdt"));
                stu.setImage(rs.getBytes("hinhAnh"));
                stu.setMajorId(rs.getInt("idNganh"));
                listStudent.add(stu);
            }
            cstm.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }
    public void insertStudent(Student o){
        try {          
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertSinhVien (?,?,?,?,?,?,?,?)}");
            cstm.setString(1, o.getStudentName());
            cstm.setInt(2, o.getIdMajor());
            cstm.setInt(3, o.getIdMajorDetail());
            cstm.setString(4,o.getPhoneNum());
            cstm.setString(5,o.getAddress());
            cstm.setString(6, o.getEmail());
            cstm.setBytes(7, o.getImage());
            cstm.setByte(8, o.getGender());
            System.out.println(o.toString());
            cstm.execute();
            cstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateStudent(Student o){
                try {          
            Connection conn = DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_updateStudent (?,?,?,?,?,?,?,?,?)}");
            cstm.setString(1, o.getStudentName());
            cstm.setInt(2, o.getIdMajor());
            cstm.setInt(3, o.getIdMajorDetail());
            cstm.setString(4,o.getPhoneNum());
            cstm.setString(5,o.getAddress());
            cstm.setString(6, o.getEmail());
            cstm.setBytes(7, o.getImage());
            cstm.setByte(8, o.getGender());
            cstm.setInt(9, o.getStudentId());
            cstm.execute();
            System.out.println(o.toString());
            cstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
