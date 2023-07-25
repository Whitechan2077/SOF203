/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Student extends MajorDetails{
    private int studentId;
    private String studentName;
    private byte gender;
    private String email;
    private String address;
    private String phoneNum;
    private byte[] image;

    public Student(int studentId, String studentName, byte gender, String email, String address, String phoneNum, byte[] image, int majorDetaisId, String majorDetailsName, int Majorid, String majornName) {
        super(majorDetaisId, majorDetailsName, Majorid, majornName);
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.image = image;
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }
    
    public Student(String studentName, byte gender, String email, String address, String phoneNum, byte[] image, int majorDetaisId, int Majorid) {
        super(majorDetaisId, Majorid);
        this.studentName = studentName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.image = image;
    }

    public Student(int studentId, String studentName, byte gender, String email, String address, String phoneNum, byte[] image, int majorDetaisId, int Majorid) {
        super(majorDetaisId, Majorid);
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.image = image;
    }

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    
    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return studentName;
    }
                       
}
