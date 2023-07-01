package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Grade;

public class GradeRepository {

    public List<Grade> sellectAllGrade() {
        List<Grade> listGrade = new ArrayList<>();
        Connection connection = new JDBCConnection().getJBDCConnection();
        String sql = " SELECT*FROM dbo.GRADE";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setId(rs.getInt(1));
                grade.setMaSV(rs.getString(2));
                grade.setTiengAnh(rs.getInt(3));
                grade.setTinHoc(rs.getInt(4));
                grade.setGiaoDucTC(rs.getInt(5));
                listGrade.add(grade);
            }
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGrade;
    }

    public void insertGrade(Grade grade) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        String sql = "INSERT INTO dbo.GRADE VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, grade.getMaSV());
            pstmt.setInt(2, grade.getTiengAnh());
            pstmt.setInt(3, grade.getTinHoc());
            pstmt.setInt(4, grade.getGiaoDucTC());
            pstmt.execute();
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateGrade(String location, String maSv, int TiengAnh, int Tin, int GiaoDucTC) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        String updateMaSv = "UPDATE dbo.GRADE SET dbo.GRADE.maSv=(?)WHERE dbo.GRADE.maSv=(?)";
        String updateTA = "UPDATE dbo.GRADE SET dbo.GRADE.tiengAnh=(?)WHERE dbo.GRADE.maSv=(?)";
        String updateTin = "UPDATE dbo.GRADE SET dbo.GRADE.tinHoc=(?)WHERE dbo.GRADE.maSv=(?)";
        String updateGDTC = "UPDATE dbo.GRADE SET dbo.GRADE.GDTC=(?)WHERE dbo.GRADE.maSv=(?)";
        try {
            PreparedStatement pstmt1 = connection.prepareStatement(updateMaSv);
            PreparedStatement pstmt2 = connection.prepareStatement(updateTA);
            PreparedStatement pstmt3 = connection.prepareStatement(updateTin);
            PreparedStatement pstmt4 = connection.prepareStatement(updateGDTC);

            pstmt1.setString(1, maSv);
            pstmt1.setString(2, location);

            pstmt2.setInt(1, TiengAnh);
            pstmt2.setString(2, location);

            pstmt3.setInt(1, Tin);
            pstmt3.setString(2, location);

            pstmt4.setInt(1, GiaoDucTC);
            pstmt4.setString(2, location);

            pstmt2.execute();
            pstmt3.execute();
            pstmt4.execute();
            pstmt1.execute();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteGrade(String maSV) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        String delete = "DELETE FROM dbo.GRADE WHERE dbo.GRADE.maSv=(?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(delete);
            pstmt.setString(1, maSV);
            pstmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
