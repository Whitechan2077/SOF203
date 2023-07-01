package repository;

import java.util.List;
import model.SinhVien;
import java.sql.*;
import java.util.ArrayList;

public class SinhVienRepository {

    public List<SinhVien> sellectAllSinhVien() {
        List<SinhVien> listSV = new ArrayList<>();
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT*FROM STUDENT");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSdt(rs.getString(4));
                sv.setGioiTinh(rs.getString(5));
                sv.setDiaChi(rs.getString(6));
                sv.setAvatar(rs.getBytes(7));
                listSV.add(sv);
            }
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSV;
    }

    public void addSinhVien(SinhVien sv) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            String sql = "INSERT INTO dbo.STUDENT VALUES( ?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getSdt());
            pstmt.setString(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());
            pstmt.setBytes(7, sv.getAvatar());
            pstmt.execute();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSinhVien(String maSV) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            String deleteFK = "DELETE FROM dbo.GRADE WHERE dbo.GRADE.maSv =(?)";
            String deletePK = "DELETE FROM dbo.STUDENT WHERE dbo.STUDENT.maSv =(?)";
            PreparedStatement pstmt1 = connection.prepareStatement(deleteFK);
            pstmt1.setString(1, maSV);
            PreparedStatement pstmt2 = connection.prepareStatement(deletePK);
            pstmt2.setString(1, maSV);
            pstmt1.execute();
            pstmt2.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSinhVien(String location, String code, String name, String email, String sdt, String gender, String address, byte[] avatar) {
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            String updateCode = "UPDATE dbo.STUDENT SET dbo.STUDENT.maSv=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm1 = connection.prepareStatement(updateCode);
            String updateName = "UPDATE dbo.STUDENT SET dbo.STUDENT.hoTen=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm2 = connection.prepareStatement(updateName);
            String updateEmail = "UPDATE dbo.STUDENT SET dbo.STUDENT.email=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm3 = connection.prepareStatement(updateEmail);
            String updateSdt = "UPDATE dbo.STUDENT SET dbo.STUDENT.soDT=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm4 = connection.prepareStatement(updateSdt);
            String updateGender = "UPDATE dbo.STUDENT SET dbo.STUDENT.gioiTinh=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm5 = connection.prepareStatement(updateGender);
            String updateAddress = "UPDATE dbo.STUDENT SET dbo.STUDENT.diaChi=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm6 = connection.prepareStatement(updateAddress);
            String updateAvatar = "UPDATE dbo.STUDENT SET dbo.STUDENT.avatar=(?) WHERE dbo.STUDENT.maSv=(?)";
            PreparedStatement pstm7 = connection.prepareStatement(updateAvatar);

            pstm1.setString(1, code);
            pstm1.setString(2, location);

            pstm2.setString(1, name);
            pstm2.setString(2, location);

            pstm3.setString(1, email);
            pstm3.setString(2, location);

            pstm4.setString(1, sdt);
            pstm4.setString(2, location);

            pstm5.setString(1, gender);
            pstm5.setString(2, location);

            pstm6.setString(1, address);
            pstm6.setString(2, location);

            pstm7.setBytes(1, avatar);
            pstm7.setString(2, location);

            pstm2.execute();
            pstm3.execute();
            pstm4.execute();
            pstm5.execute();
            pstm6.execute();
            pstm7.execute();
            pstm1.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
