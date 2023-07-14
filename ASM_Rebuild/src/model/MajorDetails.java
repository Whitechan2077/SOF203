/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class MajorDetails{
    private int id;
    private int idMajor;
    private String majorName;
    private String code;
    private String name;

    public MajorDetails(int id, int idMajor, String code, String name) {
        this.id = id;
        this.idMajor = idMajor;
        this.code = code;
        this.name = name;
    }

    public MajorDetails(int idMajor, String code, String name) {
        this.idMajor = idMajor;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MajorDetails{" + "id=" + id + ", idMajor=" + idMajor + ", code=" + code + ", name=" + name + '}';
    }
    
    
}
