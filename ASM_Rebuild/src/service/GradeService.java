/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import model.Grade;
import utilities.DatabaseConnection;
/**
 *
 * @author buidu
 */
public class GradeService {
    public LinkedList<Grade> getAllGradeByStudentId(int id){
        LinkedList<Grade> listGrade = new LinkedList<>();        
        try {
            Connection conn  = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareCall("""
                                                      	SELECT Mon_Hoc.tenMon,Mon_Hoc.maMon,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
                                                      	FROM Diem JOIN Sinh_Vien ON Diem.idSinhVien = Sinh_Vien.idSinhVien 
                                                      	JOIN Mon_Hoc ON Diem.idMonHoc = Mon_Hoc.idMonHoc
                                                      	WHERE Sinh_Vien.idSinhVien = ?""");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                listGrade.add(new Grade(rs.getString("tenMon"),rs.getString("maMon"),rs.getDouble("lab1"), rs.getDouble("lab2"), rs.getDouble("lab3"), rs.getDouble("lab4"), rs.getDouble("lab5"), rs.getDouble("lab6"), rs.getDouble("lab7"), rs.getDouble("lab8"), rs.getDouble("asm1"), rs.getDouble("asm2"), rs.getDouble("asmBaoVe"), rs.getDouble("tbm")));
            }
            psmt.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGrade;
    }
    public LinkedList<Grade> getAllListStudentByLectureIdAndClassId(int idLecture,int Classid,int subjectID){
      LinkedList<Grade> listGrade = new LinkedList<>();        
        try {
            Connection conn  = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareCall("""
	SELECT Diem.idSinhVien,ThamGiaHoc.idLop,tenSinhVien,Diem.idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm FROm Diem 
        	JOIN Sinh_Vien ON Diem.idSinhVien = Sinh_Vien.idSinhVien 
        	JOIN ThamGiaHoc  ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien JOIN Phan_Cong on ThamGiaHoc.idLop  = Phan_Cong.idLop
        	GROUP BY  ThamGiaHoc.idLop,tenSinhVien,Diem.idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm,Phan_Cong.idGiangVien,Diem.idSinhVien
        	HAVING Phan_Cong.idGiangVien = ? AND Diem.idMonHoc = ? AND ThamGiaHoc.idLop = ?""");
            psmt.setInt(1, idLecture);
            psmt.setInt(2, subjectID);
            psmt.setInt(3, Classid);
            
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                listGrade.add(new Grade(rs.getInt("idMonHoc"),rs.getDouble("lab1"),rs.getDouble("lab2"),rs.getDouble("lab3"), rs.getDouble("lab4"), rs.getDouble("lab5"), rs.getDouble("lab6"), rs.getDouble("lab7"), rs.getDouble("lab8"), rs.getDouble("asm1"), rs.getDouble("asm2"), rs.getDouble("asmBaoVe"), rs.getDouble("tbm"),rs.getInt("idSinhVien"), rs.getString("tenSinhVien")));
            }
            psmt.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGrade;
    }
    public Grade getStudentMarkByid(int studentId,int lectureId,int classId,int subjectId){
           Grade grade = new Grade();
        try {
            Connection conn  = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareCall("""
       SELECT Sinh_Vien.idSinhVien,tenSinhVien,Mon_Hoc.maMon,Mon_Hoc.idMonHoc,Mon_Hoc.tenMon,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
       	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
       		 JOIN ThamGiaHoc ON ThamGiaHoc.idLop = ThamGiaHoc.idLop
       		 JOIN Sinh_Vien ON ThamGiaHoc.idSinhVien = Sinh_Vien.idSinhVien 
       		 JOIN Diem on Sinh_Vien.idSinhVien = Diem.idSinhVien 
       		 JOIN Mon_Hoc ON Diem.idMonHoc = Mon_Hoc.idMonHoc
       	WHERE Phan_Cong.idGiangVien = ? AND lopHoc.idLop=? AND Diem.idMonHoc = ? AND Sinh_Vien.idSinhVien = ?""");
            psmt.setInt(1, lectureId);
            psmt.setInt(2, classId);
            psmt.setInt(3, subjectId);
            psmt.setInt(4, studentId);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {                
            grade.setStudentName(rs.getString("tenSinhVien"));
            grade.setSubjecCode(rs.getString("maMon"));
            grade.setSubjectName(rs.getString("tenMon"));
            grade.setStudentName(rs.getString("tenSinhVien"));
            grade.setLab1(rs.getDouble("lab1"));
            grade.setLab2(rs.getDouble("lab2"));
            grade.setLab3(rs.getDouble("lab3"));
            grade.setLab4(rs.getDouble("lab4"));
            grade.setLab5(rs.getDouble("lab5"));
            grade.setLab6(rs.getDouble("lab6"));
            grade.setLab7(rs.getDouble("lab7"));
            grade.setLab8(rs.getDouble("lab8"));
            grade.setAssignment1(rs.getDouble("asm1"));
            grade.setAssignment2(rs.getDouble("asm2"));
            grade.setFinalAssignment(rs.getDouble("asmBaoVe"));
            }
            psmt.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MajorDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grade;
    }
    public void updateGrade(Grade o){
        try {
            Connection conn  = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareCall("""
                UPDATE Diem SET lab1 = ? ,lab2= ?,lab3= ?,lab4= ?,lab5= ?,lab6= ?,lab7=?,lab8= ?,asm1= ?,asm2= ?,asmBaoVe= ?
                    WHERE  Diem.idMonHoc = ? AND Diem.idSinhVien = ?"""
            );
            psmt.setDouble(1, o.getLab1());
            psmt.setDouble(2, o.getLab2());
            psmt.setDouble(3, o.getLab3());
            psmt.setDouble(4, o.getLab4());
            psmt.setDouble(5, o.getLab5());
            psmt.setDouble(6, o.getLab6());
            psmt.setDouble(7, o.getLab7());
            psmt.setDouble(8, o.getLab8());
            psmt.setDouble(9, o.getAssignment1());
            psmt.setDouble(10, o.getAssignment2());
            psmt.setDouble(11, o.getFinalAssignment());
            psmt.setDouble(12, o.getSubjectId());
            psmt.setDouble(13, o.getStudentId());
            psmt.executeUpdate();
            System.out.println("Update thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(GradeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
