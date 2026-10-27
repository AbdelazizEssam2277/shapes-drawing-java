/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */

import java.util.Date;

public abstract class Shape {
    protected Date dateCreated;
    protected String color;
    
    public Shape() {
        this.dateCreated = new Date();
        this.color = "black";
    }
    
    public Shape(String color) {
        this.dateCreated = new Date();
        this.color = color;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public String getColor() {
        return color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
}