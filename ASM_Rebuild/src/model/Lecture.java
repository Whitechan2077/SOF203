/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Lecture {
    private int lectureid;
    private String lectureName;
    private int idMajor;
    private String majorName;
    private String phoneNum;
    private byte gender;
    private String address;
    private byte[] img;
    private String email;
    
    public Lecture(int lectureid, String lectureName, int idMajor, String majorName, String phoneNum, byte gender, String address, byte[] img) {
        this.lectureid = lectureid;
        this.lectureName = lectureName;
        this.idMajor = idMajor;
        this.majorName = majorName;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
    }

    public Lecture(int lectureid, String lectureName, String majorName, String phoneNum, byte gender, String address, byte[] img,String email) {
        this.lectureid = lectureid;
        this.lectureName = lectureName;
        this.majorName = majorName;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
        this.email = email;
    }

    public Lecture(String lectureName, int idMajor, String phoneNum, byte gender, String address, byte[] img, String email) {
        this.lectureName = lectureName;
        this.idMajor = idMajor;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
        this.email = email;
    }
    
    public Lecture() {
    }

    public int getLectureid() {
        return lectureid;
    }

    public void setLectureid(int lectureid) {
        this.lectureid = lectureid;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
