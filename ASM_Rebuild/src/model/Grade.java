/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Grade extends Student{
    private int gradeCode;
    private int subjectId;
    private String subjectName;
    private String subjecCode;
    private double lab1;
    private double lab2;
    private double lab3;
    private double lab4;
    private double lab5;
    private double lab6;
    private double lab7;
    private double lab8;
    private double assignment1;
    private double assignment2;
    private double finalAssignment;
    private double avg;

    public Grade(int gradeCode, int subjectId, String subjectName, String subjecCode, double lab1, double lab2, double lab3, double lab4, double lab5, double lab6, double lab7, double lab8, double assignment1, double assignment2, double finalAssignment, double avg, int studentId, String studentName) {
        super(studentId, studentName);
        this.gradeCode = gradeCode;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjecCode = subjecCode;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.lab5 = lab5;
        this.lab6 = lab6;
        this.lab7 = lab7;
        this.lab8 = lab8;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalAssignment = finalAssignment;
        this.avg = avg;
    }

    public Grade() {
    }
    
    public Grade(int subjectId, String subjectName, String subjecCode, double lab1, double lab2, double lab3, double lab4, double lab5, double lab6, double lab7, double lab8, double assignment1, double assignment2, double finalAssignment, double avg, int studentId, String studentName) {
        super(studentId, studentName);
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjecCode = subjecCode;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.lab5 = lab5;
        this.lab6 = lab6;
        this.lab7 = lab7;
        this.lab8 = lab8;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalAssignment = finalAssignment;
        this.avg = avg;
    }

    public Grade(int subjectId, double lab1, double lab2, double lab3, double lab4, double lab5, double lab6, double lab7, double lab8, double assignment1, double assignment2, double finalAssignment, double avg, int studentId, String studentName) {
        super(studentId, studentName);
        this.subjectId = subjectId;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.lab5 = lab5;
        this.lab6 = lab6;
        this.lab7 = lab7;
        this.lab8 = lab8;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalAssignment = finalAssignment;
        this.avg = avg;
    }
    
    public Grade(String subjectName, String subjecCode, double lab1, double lab2, double lab3, double lab4, double lab5, double lab6, double lab7, double lab8, double assignment1, double assignment2, double finalAssignment, double avg) {
        this.subjectName = subjectName;
        this.subjecCode = subjecCode;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.lab5 = lab5;
        this.lab6 = lab6;
        this.lab7 = lab7;
        this.lab8 = lab8;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalAssignment = finalAssignment;
        this.avg = avg;
    }

    public Grade(int subjectId, double lab1, double lab2, double lab3, double lab4, double lab5, double lab6, double lab7, double lab8, double assignment1, double assignment2, double finalAssignment, int studentId) {
        super(studentId);
        this.subjectId = subjectId;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.lab5 = lab5;
        this.lab6 = lab6;
        this.lab7 = lab7;
        this.lab8 = lab8;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalAssignment = finalAssignment;
    }
    
    public int getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(int gradeCode) {
        this.gradeCode = gradeCode;
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

    public String getSubjecCode() {
        return subjecCode;
    }

    public void setSubjecCode(String subjecCode) {
        this.subjecCode = subjecCode;
    }

    public double getLab1() {
        return lab1;
    }

    public void setLab1(double lab1) {
        this.lab1 = lab1;
    }

    public double getLab2() {
        return lab2;
    }

    public void setLab2(double lab2) {
        this.lab2 = lab2;
    }

    public double getLab3() {
        return lab3;
    }

    public void setLab3(double lab3) {
        this.lab3 = lab3;
    }

    public double getLab4() {
        return lab4;
    }

    public void setLab4(double lab4) {
        this.lab4 = lab4;
    }

    public double getLab5() {
        return lab5;
    }

    public void setLab5(double lab5) {
        this.lab5 = lab5;
    }

    public double getLab6() {
        return lab6;
    }

    public void setLab6(double lab6) {
        this.lab6 = lab6;
    }

    public double getLab7() {
        return lab7;
    }

    public void setLab7(double lab7) {
        this.lab7 = lab7;
    }

    public double getLab8() {
        return lab8;
    }

    public void setLab8(double lab8) {
        this.lab8 = lab8;
    }

    public double getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(double assignment1) {
        this.assignment1 = assignment1;
    }

    public double getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(double assignment2) {
        this.assignment2 = assignment2;
    }

    public double getFinalAssignment() {
        return finalAssignment;
    }

    public void setFinalAssignment(double finalAssignment) {
        this.finalAssignment = finalAssignment;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    
    
}
