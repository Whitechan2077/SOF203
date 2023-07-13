/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class StudentDetail {
    private int id;
    private String name;
    private byte gender;
    private String email;
    private int majorId;
    private String major;
    private String address;
    private String phoneNum;
    private int majorDetailId;
    private String majorDetail;
    private byte[] image;

    public StudentDetail(int id, String name, byte gender, String email, String major, String address, String majorDetail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.major = major;
        this.address = address;
        this.majorDetail = majorDetail;
    }

    public StudentDetail(int id, String name, byte gender, String email, int majorId, String major, String address, String phoneNum, int majorDetailId, String majorDetail, byte[] image) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.majorId = majorId;
        this.major = major;
        this.address = address;
        this.phoneNum = phoneNum;
        this.majorDetailId = majorDetailId;
        this.majorDetail = majorDetail;
        this.image = image;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getMajorDetailId() {
        return majorDetailId;
    }

    public void setMajorDetailId(int majorDetailId) {
        this.majorDetailId = majorDetailId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public StudentDetail(int id, String name, byte gender, String email, String major, String address, String phoneNum, String majorDetail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.major = major;
        this.address = address;
        this.phoneNum = phoneNum;
        this.majorDetail = majorDetail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public StudentDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajorDetail() {
        return majorDetail;
    }

    public void setMajorDetail(String majorDetail) {
        this.majorDetail = majorDetail;
    }

    @Override
    public String toString() {
        return "StudentDetail{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", major=" + major + ", address=" + address + ", majorDetail=" + majorDetail + '}';
    }
    
    
}
