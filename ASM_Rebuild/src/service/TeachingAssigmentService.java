/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import utilities.DatabaseConnection;
import model.TeachingAssignment;
import java.sql.PreparedStatement;
import model.Lecture;

/**
 *
 * @author buidu
 */
public class TeachingAssigmentService {

    public LinkedList<TeachingAssignment> getAllListTeachingAssignment(int id) {
        LinkedList<TeachingAssignment> listTeachingAssignment = new LinkedList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
              SELECT Phan_Cong.idPhanCong,Phan_Cong.idLop,lopHoc.maLop,Phan_Cong.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon,Phan_Cong.idMonHoc 
                        FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
                                       JOIN Mon_Hoc ON Mon_Hoc.idMonHoc = Phan_Cong.idMonHoc
                         WHERE lopHoc.idLop = ?""");

            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listTeachingAssignment.add(new TeachingAssignment(rs.getInt("idPhanCong"), rs.getInt("idLop"), rs.getString("maLop"), rs.getInt("idMonHoc"), rs.getString("maMon"), rs.getString("tenMon"))); 
            }
            conn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTeachingAssignment;
    }

    public void insertClass(TeachingAssignment o) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertPhanCong (?,?)}");
            cstm.setInt(1, o.getClassId());
            cstm.setInt(2,o.getSubjectId());
            cstm.execute();
            cstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<Lecture> getAllListLecture(int idClass, int Majorid) {
        LinkedList<Lecture> listLecture = new LinkedList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
                SELECT gv.idGiangVien, gv.tenGiangVien
                       FROM Giang_Vien gv
                       LEFT JOIN Phan_Cong pc ON gv.idGiangVien = pc.idGiangVien AND pc.idLop = ? AND gv.idNganh =?
                       WHERE pc.idPhanCong IS NULL;""");
            pstm.setInt(1, idClass);
            pstm.setInt(2, Majorid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listLecture.add(new Lecture(rs.getInt("idGiangVien"), rs.getString("tenGiangVien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLecture;
    }

    public void updateLectureAssignment(int lectureId, int classId, int subjectId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
            UPDATE Phan_Cong SET idGiangVien = ? WHERE idLop = ? AND idMonHoc = ?
            """);
            pstm.setInt(1, lectureId);
            pstm.setInt(2, classId);
            pstm.setInt(3, subjectId);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<TeachingAssignment> getAllAssignment(int classID) {
        LinkedList<TeachingAssignment> listAssignment = new LinkedList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
            SELECT lopHoc.idLop,lopHoc.maLop,Mon_Hoc.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon,Phan_Cong.idGiangVien,Giang_Vien.tenGiangVien,Mon_Hoc.idMonHoc
		FROM Phan_Cong LEFT JOIN Giang_Vien ON Phan_Cong.idGiangVien = Giang_Vien.idGiangVien
		FULL JOIN lopHoc ON Phan_Cong.idLop =  lopHoc.idLop FULL JOIN Mon_Hoc ON Mon_Hoc.idMonHoc= Phan_Cong.idMonHoc
                WHERE Phan_Cong.idLop = ?
            """);
            pstm.setInt(1, classID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listAssignment.add(new TeachingAssignment(rs.getInt("idLop"), rs.getString("maLop"), rs.getInt("idGiangVien"), rs.getString("tenGiangVien"), rs.getInt("idMonHoc"), rs.getString("maMon"), rs.getString("tenMon")));
            }
            conn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAssignment;
    }

    public void insertStudentAssigment(TeachingAssignment o) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
              INSERT INTO ThamGiaHoc(idLop,idSinhVien)
                 VALUES(?,?)""");
            pstm.setInt(1, o.getClassId());
            pstm.setInt(2, o.getSubjectId());
            pstm.execute();
            conn.close();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<TeachingAssignment> fillStudentAssignmentToTable(int id) {
        LinkedList<TeachingAssignment> listStudent = new LinkedList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareCall("""
              SELECT lopHoc.maLop,Sinh_Vien.idSinhVien,tenSinhVien
                     FROM ThamGiaHoc JOIN lopHoc ON ThamGiaHoc.idLop = lopHoc.idLop 
                        JOIN Sinh_Vien ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien 
                         WHERE lopHoc.idLop = ?""");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                listStudent.add(new TeachingAssignment(rs.getString("maLop"),rs.getInt("idSinhVien"), rs.getString("tenSinhVien")));
            }
            conn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingAssigmentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }
}
