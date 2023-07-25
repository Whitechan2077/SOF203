/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Lecture extends Major{
    private int lectureId;
    private String lectureName;
    private String phoneNum;
    private byte gender;
    private String address;
    private byte[] img;
    private String email;

    public Lecture(int lectureId, String lectureName, String phoneNum, byte gender, String address, byte[] img, String email, int Majorid, String majornName) {
        super(Majorid, majornName);
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
        this.email = email;
    }

    public Lecture() {
    }
    
    public Lecture(int lectureId, String lectureName) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }
    
    
    public Lecture(int lectureId, String lectureName, String phoneNum, byte gender, String address, byte[] img, String email, int Majorid) {
        super(Majorid);
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
        this.email = email;
    }

    public Lecture(String lectureName, String phoneNum, byte gender, String address, byte[] img, String email, int Majorid) {
        super(Majorid);
        this.lectureName = lectureName;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.address = address;
        this.img = img;
        this.email = email;
    }
    
    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
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

    @Override
    public String toString() {
        return lectureName;
    }
            
}
