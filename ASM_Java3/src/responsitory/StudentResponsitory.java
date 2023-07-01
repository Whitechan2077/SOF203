/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;
import model.Student;
import java.util.LinkedList;
import java.sql.*;

/**
 *
 * @author buidu
 */
public class StudentResponsitory {
    
    public LinkedList<Student> getStudent() throws SQLException{
        Connection conn = ConnectDB.getConnection();
        LinkedList<Student> listStudent = new LinkedList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM STUDENT");
        while(rs.next()){
            listStudent.add(new Student(rs.getString("ID"),rs.getString("FullName"),rs.getString("Email") ,rs.getString("PhoneNumber"),rs.getString("Ad"),rs.getBoolean("Gender"),rs.getString("Img")));
        }
        conn.close();
        stm.close();
        rs.close();
        return listStudent;
    }
    public void addStudent(Student s) throws SQLException{
        Connection conn = ConnectDB.getConnection();
        CallableStatement cstm = conn.prepareCall("{CALL p_InsertStudent(?,?,?,?,?,?,?)}");
        cstm.setString(1, s.getId());
        cstm.setString(2, s.getFullName());
        cstm.setString(3, s.getEmail());
        cstm.setString(4, s.getPhoneNum());
        cstm.setBoolean(5, s.isGender());
        cstm.setString(6, s.getAddress());
        cstm.setString(7, s.getImg());
        cstm.execute();
        conn.close();
        cstm.close();
    }
    public void deleteUser(String id) throws SQLException{
        Connection conn = ConnectDB.getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("DELETE FROM STUDENT WHERE ID like "+ "'"+id+"'");
    }
    public void updateUser(String id,Student s) throws SQLException{
        Connection conn =  ConnectDB.getConnection();
        PreparedStatement pstm = conn.prepareStatement("UPDATE STUDENT SET ID = ?,FullName = ?,Email=?,PhoneNumber = ?,Gender = ?,Ad=?,Img=? WHERE ID like ?");
        pstm.setString(1,s.getId());
        pstm.setString(2,s.getFullName());
        pstm.setString(3,s.getEmail());
        pstm.setString(4,s.getPhoneNum());
        pstm.setBoolean(5,s.isGender());
        pstm.setString(6,s.getAddress());
        pstm.setString(7,s.getImg());
        pstm.setString(8, id);
        pstm.executeUpdate();
    }
    public Student findStudent(String id) throws SQLException{
        Student stu  = new Student();
        Connection conn = ConnectDB.getConnection();
        Statement  stm = conn.createStatement();
        ResultSet rs =  stm.executeQuery("SELECT * FROM STUDENT WHERE ID LIKE "+"'"+id+"'");
        while (rs.next()){
            stu.setId(rs.getString("ID"));
            stu.setFullName(rs.getString("FullName"));
            stu.setEmail(rs.getString("Email"));
            stu.setPhoneNum(rs.getString("PhoneNumber"));
            stu.setGender(rs.getBoolean("Gender"));
            stu.setAddress(rs.getString("Ad"));
            stu.setImg(rs.getString("Img"));
        }
        return stu;
    }
}
