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
    private int rommId;
    private String roomName;
    private String classCode;
    private int subjectId;
    private String subjectName;

    public Class(int idClass, String classCode, int rommId, String roomName, int majorDetaisId, String majorDetailsName, int Majorid, String majornName) {
        super(majorDetaisId, majorDetailsName, Majorid, majornName);
        this.idClass = idClass;
        this.classCode = classCode;
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

    public Class(int idClass, String classCode, int subjectId, String subjectName, String majorDetailsName) {
        super(majorDetailsName);
        this.idClass = idClass;
        this.classCode = classCode;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
    
    public Class(int idClass, String classCode, String majorDetailsName) {
        super(majorDetailsName);
        this.idClass = idClass;
        this.classCode = classCode;
    }
    
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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



    public int getRommId() {
        return rommId;
    }

    public void setRommId(int rommId) {
        this.rommId = rommId;
    }

    @Override
    public String toString() {
        return classCode+"-"+super.getMajorDetailsName();
    }
    
}
