/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.LinkedList;
import responsitory.StudentResponsitory;
import model.Student;
/**
 *
 * @author buidu
 */
public class StudentService {

    private StudentResponsitory sts = new StudentResponsitory();

    public LinkedList<Student> getStudents() throws SQLException{
        return sts.getStudent();
    }
    public void addStudent(Student s) throws SQLException{
        sts.addStudent(s);
    }
    public  void delete(String id) throws SQLException{
        sts.deleteUser(id);
    }
    public void updateStudent(String id, Student s) throws SQLException{
        sts.updateUser(id, s);
    }
    public  Student findStudent(String id) throws SQLException {
        return sts.findStudent(id);
    }
}
