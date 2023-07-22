/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Class extends MajorDetails{
    private int idClass;
    private String coleClass;
    private int rommId;
    private String roomName;

    public Class(int idClass, String coleClass, int rommId, String roomName, int majorDetaisId, String majorDetailsName, int Majorid, String majornName) {
        super(majorDetaisId, majorDetailsName, Majorid, majornName);
        this.idClass = idClass;
        this.coleClass = coleClass;
        this.rommId = rommId;
        this.roomName = roomName;
    }

    public Class(int idClass, int rommId, int majorDetaisId, int Majorid) {
        super(majorDetaisId, Majorid);
        this.idClass = idClass;
        this.rommId = rommId;
    }

    public Class(int rommId, int majorDetaisId, int Majorid) {
        super(majorDetaisId, Majorid);
        this.rommId = rommId;
    }
    
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
     
    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getColeClass() {
        return coleClass;
    }

    public void setColeClass(String coleClass) {
        this.coleClass = coleClass;
    } 

    public int getRommId() {
        return rommId;
    }

    public void setRommId(int rommId) {
        this.rommId = rommId;
    }

    @Override
    public String toString() {
        return coleClass+"-"+super.getMajorDetailsName();
    }
    
}
