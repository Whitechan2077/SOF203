/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Subject extends MajorDetails{
    private int subjectId;
    private String subjectCode;
    private String subjectName;

    public Subject(int subjectId, String subjectCode, String subjectName, int majorDetaisId, String majorDetailsName, int Majorid, String majornName) {
        super(majorDetaisId, majorDetailsName, Majorid, majornName);
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public Subject(String subjectName, int majorDetaisId, int Majorid) {
        super(majorDetaisId, Majorid);
        this.subjectName = subjectName;
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

    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + '}';
    }   
}
