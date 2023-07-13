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
    private int id;
    private String name;
    private String code;

    public Major() {
    }

    public Major(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Major(String name, String code) {
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Major{" + "id=" + id + ", name=" + name + ", code=" + code + '}';
    }
    
    
}
