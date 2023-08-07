/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author buidu
 */
public class Book {
    private String bookCode;
    private String bookName;
    private String publishingCompany;
    private int NumberOfPages;
    private int Quantity;
    private double price;
    private Date inputDate;
    private String place;
    private String bookCategory;

    public Book(String bookCode, String bookName, String publishingCompany, int NumberOfPages, int Quantity, double price, Date inputDate, String place, String bookCategory) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.publishingCompany = publishingCompany;
        this.NumberOfPages = NumberOfPages;
        this.Quantity = Quantity;
        this.price = price;
        this.inputDate = inputDate;
        this.place = place;
        this.bookCategory = bookCategory;
    }

    public Book(String bookCode, String bookName, int NumberOfPages, double price) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.NumberOfPages = NumberOfPages;
        this.price = price;
    }

    
    public Book() {
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getNumberOfPages() {
        return NumberOfPages;
    }

    public void setNumberOfPages(int NumberOfPages) {
        this.NumberOfPages = NumberOfPages;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
    
    
}
