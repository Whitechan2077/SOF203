/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int studentId;
    private int LectureId;
    private int MaId;

    public User(int id, String username, String password, int studentId, int LectureId, int MaId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.studentId = studentId;
        this.LectureId = LectureId;
        this.MaId = MaId;
    }

    public User() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLectureId() {
        return LectureId;
    }

    public void setLectureId(int LectureId) {
        this.LectureId = LectureId;
    }

    public int getMaId() {
        return MaId;
    }

    public void setMaId(int MaId) {
        this.MaId = MaId;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", studentId=" + studentId + ", LectureId=" + LectureId + ", MaId=" + MaId + '}';
    }  
}
