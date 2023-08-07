/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author buidu
 */
public class Product {
    private int id;
    private  String name;
    private int quantity;
    private String Color;
    private double price;

    public Product(String name, int quantity, String Color, double price,int id) {
        this.name = name;
        this.quantity = quantity;
        this.Color = Color;
        this.price = price;
        this.id = id;
    }

    public Product(String name, int quantity, String Color, double price) {
        this.name = name;
        this.quantity = quantity;
        this.Color = Color;
        this.price = price;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
