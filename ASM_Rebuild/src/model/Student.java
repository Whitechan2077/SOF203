/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Student {
    private int studentId;
    private String studentName;
    private int idMajor;
    private int idMajorDetail;
    private byte gender;
    private String phoneNum;
    private String address;
    private String email;
    private byte[] image;

    public Student(int studentId, String studentName, int idMajor, int idMajorDetail, byte gender, String phoneNum, String address, String email, byte[] image) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.idMajor = idMajor;
        this.idMajorDetail = idMajorDetail;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public Student(String studentName, int idMajor, int idMajorDetail, byte gender, String phoneNum, String address, String email, byte[] image) {
        this.studentName = studentName;
        this.idMajor = idMajor;
        this.idMajorDetail = idMajorDetail;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }

    public int getIdMajorDetail() {
        return idMajorDetail;
    }

    public void setIdMajorDetail(int idMajorDetail) {
        this.idMajorDetail = idMajorDetail;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName=" + studentName + ", idMajor=" + idMajor + ", idMajorDetail=" + idMajorDetail + ", gender=" + gender + ", phoneNum=" + phoneNum + ", address=" + address + ", email=" + email + ", image=" + image + '}';
    }
    
}
