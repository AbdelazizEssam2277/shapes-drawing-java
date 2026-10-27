/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */

public class Circle extends Shape implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String howToDraw() {
        return "Draw a circle with radius " + radius + " using a compass";
    }
    
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}