/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Employee {
    private String id;
    private String name;
    private double salary;
    private String education;

    public Employee(String id, String name, double salary, String education) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.education = education;
    }

    public Employee(String name, double salary, String education) {
        this.name = name;
        this.salary = salary;
        this.education = education;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
    
}
