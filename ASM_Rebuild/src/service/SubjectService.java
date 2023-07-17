/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.Subject;
import utilities.DataBaseConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class SubjectService {
    public LinkedList<Subject> getrAllSubjectsData(){
        LinkedList<Subject> listSubjet = new LinkedList<>();
        try {
            Connection conn =  DataBaseConnection.getConnection();
            Statement stm =  conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from   dbo.SubjectData()");
            while (rs.next()) {                
                listSubjet.add(new Subject(rs.getInt("idMonHoc"),rs.getString("maMon"),rs.getString("tenMon"),rs.getInt("idNganhHep"),rs.getString("tenNganhHep"),rs.getInt("idNganh"),rs.getString("tenNganh")));
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  listSubjet;
    }
    public void insertSubject(Subject o){
        try {
            Connection conn =  DataBaseConnection.getConnection();
            CallableStatement cstm = conn.prepareCall("{CALL p_insertMonHoc (?,?,?)}");
            cstm.setInt(1, o.getMajorid());
            if (o.getMajorDetaisId() == 0) {
                cstm.setObject(2, null);
            }
            else{
                cstm.setInt(2, o.getMajorDetaisId());

            }
            cstm.setString(3, o.getSubjectName());
            cstm.execute();
            conn.close();
            cstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(o.toString());
    }
}
