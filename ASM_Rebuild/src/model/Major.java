/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Major {
    private int Majorid;
    private String majornName;
    private String majorCode;

    public Major() {
    }

    public Major(int Majorid, String majornName, String majorCode) {
        this.Majorid = Majorid;
        this.majornName = majornName;
        this.majorCode = majorCode;
    }

    public Major(String majornName, String majorCode) {
        this.majornName = majornName;
        this.majorCode = majorCode;
    }

    public Major(int Majorid, String majornName) {
        this.Majorid = Majorid;
        this.majornName = majornName;
    }
    
    public Major(int Majorid) {
        this.Majorid = Majorid;
    }

    public int getMajorid() {
        return Majorid;
    }

    public void setMajorid(int Majorid) {
        this.Majorid = Majorid;
    }
    public String getMajornName() {
        return majornName;
    }

    public void setMajornName(String majornName) {
        this.majornName = majornName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Override
    public String toString() {
        return  majornName;
    }
    
}
