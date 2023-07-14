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

    public Classroom(int roomId, int rommcode) {
        this.roomId = roomId;
        this.rommcode = rommcode;
    }   
}
