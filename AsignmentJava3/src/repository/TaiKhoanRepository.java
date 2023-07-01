package repository;

import model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanRepository {

    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> listTK = new ArrayList<>();
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT*FROM dbo.USERS");
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setUserName(rs.getString(1));
                tk.setPassWord(rs.getString(2));
                tk.setRoles(rs.getString(3));
                listTK.add(tk);
            }
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
    }

    public void addTaiKhoan(TaiKhoan tk){
        Connection connection = new JDBCConnection().getJBDCConnection();
        try {
            String sql = "INSERT INTO dbo.USERS VALUES( ?,?,?)";
            PreparedStatement pstt = connection.prepareStatement(sql);
            pstt.setString(1, tk.getUserName());
            pstt.setString(2, tk.getPassWord());
            pstt.setString(3, tk.getRoles());
            pstt.execute();
            pstt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePass(String tenTK, String newPass) {
        Connection connection = JDBCConnection.getJBDCConnection();
        try {
            String update = "UPDATE dbo.USERS SET dbo.USERS.pass=(?) WHERE dbo.USERS.userName=(?)";
            PreparedStatement pstt = connection.prepareStatement(update);
            pstt.setString(1, newPass);
            pstt.setString(2, tenTK);
            pstt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
