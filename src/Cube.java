/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */

public class Cube extends ThreeDShape implements Drawable {
    private double side;
    
    public Cube(double side) {
        super();
        this.side = side;
    }
    
    public Cube(String color, double side) {
        super(color);
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return 6 * side * side;
    }
    
    @Override
    public double getPerimeter() {
        return 12 * side;
    }
    
    @Override
    public double getVolume() {
        return side * side * side;
    }
    
    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side + " using perspective drawing";
    }
    
    @Override
    public String toString() {
        return "Cube[side=" + side + ", color=" + color + "]";
    }
}