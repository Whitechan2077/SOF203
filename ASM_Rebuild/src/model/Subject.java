/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Subject {
    private int subjectId;
    private String subjectCode;
    private String subjectName;
    private int majorIdl;
    private String majorName;
    private int majorDetails;
    private String majorDetailsName;

    public Subject(int subjectId, String subjectCode, String subjectName, int majorIdl, String majorName, int majorDetails, String majorDetailsName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.majorIdl = majorIdl;
        this.majorName = majorName;
        this.majorDetails = majorDetails;
        this.majorDetailsName = majorDetailsName;
    }

    public Subject() {
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMajorIdl() {
        return majorIdl;
    }

    public void setMajorIdl(int majorIdl) {
        this.majorIdl = majorIdl;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getMajorDetails() {
        return majorDetails;
    }

    public void setMajorDetails(int majorDetails) {
        this.majorDetails = majorDetails;
    }

    public String getMajorDetailsName() {
        return majorDetailsName;
    }

    public void setMajorDetailsName(String majorDetailsName) {
        this.majorDetailsName = majorDetailsName;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", majorIdl=" + majorIdl + ", majorName=" + majorName + ", majorDetails=" + majorDetails + ", majorDetailsName=" + majorDetailsName + '}';
    }  
}
