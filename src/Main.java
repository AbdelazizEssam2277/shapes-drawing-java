/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Drawable> shapes = readFromFile("input.txt");
            
            double total = getTotalArea(shapes);
            
            writeToFile(shapes, total, "sumAreas.txt");
            
            showInConsole(shapes, total);
            
            Drawable[] array = makeArray(shapes);
            System.out.println("\n=== Array Verification ===");
            System.out.println("Array size: " + array.length);
            System.out.println("Actual shapes: " + shapes.size());
            
            showWindow(shapes);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            makeSampleFile();
        }
    }
    
    private static Drawable[] makeArray(ArrayList<Drawable> shapes) {
        int size = Math.max(2, shapes.size());
        Drawable[] array = new Drawable[size];
        
        for (int i = 0; i < shapes.size(); i++) {
            array[i] = shapes.get(i);
        }
        
        if (shapes.size() < 2) {
            System.out.println("Adding default shapes to meet minimum array size of 2");
            for (int i = shapes.size(); i < 2; i++) {
                array[i] = new Circle(5.0); // Default circle
                System.out.println("Added default circle at index " + i);
            }
        }
        
        return array;
    }
    
    private static void showWindow(ArrayList<Drawable> shapes) {
        SwingUtilities.invokeLater(() -> {
            new ShapeGUI(shapes);
        });
    }
    
    private static ArrayList<Drawable> readFromFile(String filename) throws FileNotFoundException {
        ArrayList<Drawable> list = new ArrayList<>();
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (line.isEmpty()) continue;
            
            String[] parts = line.split(" ");
            String type = parts[0];
            double value = Double.parseDouble(parts[1]);
            
            if (type.equalsIgnoreCase("circle")) {
                list.add(new Circle(value));
            } else if (type.equalsIgnoreCase("cube")) {
                list.add(new Cube(value));
            }
        }
        scan.close();
        return list;
    }
    
    private static double getTotalArea(ArrayList<Drawable> shapes) {
        double sum = 0;
        for (Drawable d : shapes) {
            if (d instanceof Shape) {
                sum += ((Shape) d).getArea();
            }
        }
        return sum;
    }
    
    private static void writeToFile(ArrayList<Drawable> shapes, double total, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write("Total Area: " + total + "\n");
        writer.write("Number of Shapes: " + shapes.size() + "\n\n");
        
        for (Drawable d : shapes) {
            writer.write(d.toString() + "\n");
            writer.write("Area: " + ((Shape) d).getArea() + "\n");
        }
        writer.close();
        System.out.println("Results saved to " + filename);
    }
    
    private static void showInConsole(ArrayList<Drawable> shapes, double total) {
        System.out.println("\n===== RESULTS =====");
        System.out.println("Total Area: " + total);
        System.out.println("Number of Shapes: " + shapes.size());
        
        for (Drawable d : shapes) {
            System.out.println("\n" + d.toString());
            System.out.println("How to draw: " + d.howToDraw());
        }
    }
    
    private static void makeSampleFile() {
        try {
            FileWriter w = new FileWriter("input.txt");
            w.write("circle 22.5\n");
            w.write("cube 23.6\n");
            w.close();
            System.out.println("input.txt file created");
            System.out.println("Run the program again");
        } catch (IOException e) {
            System.out.println("Cannot create the file");
        }
    }
}