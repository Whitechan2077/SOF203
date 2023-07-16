/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class MajorDetails extends Major{
    private int majorDetaisId;
    private String majorDetailsCode;
    private String majorDetailsName;

    public MajorDetails(int majorDetaisId, String majorDetailsCode, String majorDetailsName, int id, String majornName, String majorCode) {
        super(id, majornName, majorCode);
        this.majorDetaisId = majorDetaisId;
        this.majorDetailsCode = majorDetailsCode;
        this.majorDetailsName = majorDetailsName;
    }

    public MajorDetails(String majorDetailsCode, String majorDetailsName, int Majorid) {
        super(Majorid);
        this.majorDetailsCode = majorDetailsCode;
        this.majorDetailsName = majorDetailsName;
    }

    public MajorDetails(int majorDetaisId, String majorDetailsName, int Majorid, String majornName) {
        super(Majorid, majornName);
        this.majorDetaisId = majorDetaisId;
        this.majorDetailsName = majorDetailsName;
    }

    public MajorDetails() {
    }

    public MajorDetails(int majorDetaisId, int Majorid) {
        super(Majorid);
        this.majorDetaisId = majorDetaisId;
    }
    
    
    public int getMajorDetaisId() {
        return majorDetaisId;
    }

    public void setMajorDetaisId(int majorDetaisId) {
        this.majorDetaisId = majorDetaisId;
    }

    public String getMajorDetailsCode() {
        return majorDetailsCode;
    }

    public void setMajorDetailsCode(String majorDetailsCode) {
        this.majorDetailsCode = majorDetailsCode;
    }

    public String getMajorDetailsName() {
        return majorDetailsName;
    }

    public void setMajorDetailsName(String majorDetailsName) {
        this.majorDetailsName = majorDetailsName;
    } 
}
