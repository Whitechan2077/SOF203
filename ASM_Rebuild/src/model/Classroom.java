/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Classroom extends Building{
    private int roomId;
    private int rommcode;

    public Classroom(int roomId, int rommcode, int idBuiding, String builingCode) {
        super(idBuiding, builingCode);
        this.roomId = roomId;
        this.rommcode = rommcode;
    }

    public Classroom(int rommcode, int idBuiding) {
        super(idBuiding);
        this.rommcode = rommcode;
    }    
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRommcode() {
        return rommcode;
    }

    public void setRommcode(int rommcode) {
        this.rommcode = rommcode;
    }

    @Override
    public String toString() {
        return "Classroom{" + "roomId=" + roomId + ", rommcode=" + rommcode + '}'+"Ten toa"+super.getBuilingCode()+"ID toa"+super.getIdBuiding();
    }
    
}
