/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class TeachingAssignment extends Subject{
    private int teachingAssignmentId;
    private int classId;
    private String classCode;
    private int lectureId;
    private String lectureName;
    private int studentID;
    private String studentName;
    
    public TeachingAssignment(int lectureId, String lectureName) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }

    public TeachingAssignment() {
    }
    
    
    
    public TeachingAssignment(int classId, int subjectId) {
        super(subjectId);
        this.classId = classId;
    }
    
    public TeachingAssignment(int lectureId, int subjectId, int majorDetaisId) {
        super(subjectId, majorDetaisId);
        this.lectureId = lectureId;
    }

        
    public TeachingAssignment(int teachingAssignmentId, int classId, String classCode, int subjectId, String subjectCode, String subjectName) {
        super(subjectId, subjectCode, subjectName);
        this.teachingAssignmentId = teachingAssignmentId;
        this.classId = classId;
        this.classCode = classCode;
    }

    public TeachingAssignment(int classId, String classCode, int lectureId, String lectureName, int subjectId, String subjectCode, String subjectName) {
        super(subjectId, subjectCode, subjectName);
        this.classId = classId;
        this.classCode = classCode;
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }

    public TeachingAssignment(String classCode, int studentID, String studentName) {
        this.classCode = classCode;
        this.studentID = studentID;
        this.studentName = studentName;
    }
    
    
    public int getTeachingAssignmentId() {
        return teachingAssignmentId;
    }

    public void setTeachingAssignmentId(int teachingAssignmentId) {
        this.teachingAssignmentId = teachingAssignmentId;
    }

    
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

     public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    @Override
    public String toString() {
        return super.getSubjectCode()+"-"+super.getSubjectName();
    }
    
}
