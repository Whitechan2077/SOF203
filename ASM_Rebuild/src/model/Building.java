/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Building {
    private int idBuiding;
    private String builingCode;

    public Building(int idBuiding, String builingCode) {
        this.idBuiding = idBuiding;
        this.builingCode = builingCode;
    }

    public Building() {
    }

    public Building(int idBuiding) {
        this.idBuiding = idBuiding;
    }
    
    public int getIdBuiding() {
        return idBuiding;
    }

    public void setIdBuiding(int idBuiding) {
        this.idBuiding = idBuiding;
    }

    public String getBuilingCode() {
        return builingCode;
    }

    public void setBuilingCode(String builingCode) {
        this.builingCode = builingCode;
    }

    @Override
    public String toString() {
        return builingCode;
    }
    
    
}
