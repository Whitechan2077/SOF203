/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.LinkedList;
import model.Room;
/**
 *
 * @author buidu
 */
public class Service {
    private LinkedList<Room> listRoom = new LinkedList<>();

    public LinkedList<Room> getListRoom() {
        return listRoom;
    }
    public void addRoom(Room r){
        listRoom.add(r);
    }
    public void delete(int index){
        listRoom.remove(index);
    }
    public void update(String name,int toatlFloor,String Building,int index){
        listRoom.get(index).setBuilding(Building);
        listRoom.get(index).setRomName(name);
        listRoom.get(index).setTotalFloor(toatlFloor);
    }
}
