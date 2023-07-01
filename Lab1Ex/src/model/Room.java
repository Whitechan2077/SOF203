/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Room {
    private String romName;
    private int totalFloor;
    private String building;

    public Room(String romName, int totalFloor, String building) {
        this.romName = romName;
        this.totalFloor = totalFloor;
        this.building = building;
    }

    public String getRomName() {
        return romName;
    }

    public void setRomName(String romName) {
        this.romName = romName;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
    
    public String getStatus(){
        String status ="";
        if (totalFloor < 3) {
            status = "Perfect";
        }
        else
            status = "My leg was broken";
        return status;
    }
}
