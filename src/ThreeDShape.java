/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */
public abstract class ThreeDShape extends Shape {
    
    public ThreeDShape() {
        super();  
    }
    
    public ThreeDShape(String color) {
        super(color);  
    }
    
    public abstract double getVolume();
}