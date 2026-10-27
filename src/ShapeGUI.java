/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITC
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeGUI extends JFrame {
    private ArrayList<Drawable> shapes;
    
    public ShapeGUI(ArrayList<Drawable> shapes) {
        this.shapes = shapes;
        setupGUI();
    }
    
    private void setupGUI() {
        setTitle("Shapes Drawing - FCI Project");
        setSize(1000, 700);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.WHITE);
        
        JTextArea infoArea = createInfoArea();
        JScrollPane scrollPane = new JScrollPane(infoArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Shapes Information"));
        
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            drawingPanel,
            scrollPane
        );
        splitPane.setResizeWeight(0.7);  
        
        add(splitPane);
        setVisible(true);
    }
    
    private JTextArea createInfoArea() {
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        StringBuilder info = new StringBuilder();
        info.append("=== Shapes Information ===\n\n");
        
        double totalArea = 0;
        int shapeCount = 1;
        
        for (Drawable shape : shapes) {
            info.append(shapeCount++).append(". ");
            
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                info.append("Circle:\n")
                    .append("   Radius: ").append(circle.getRadius()).append("\n")
                    .append("   Area: ").append(String.format("%.2f", circle.getArea())).append("\n")
                    .append("   Perimeter: ").append(String.format("%.2f", circle.getPerimeter())).append("\n")
                    .append("   Color: ").append(circle.getColor()).append("\n");
                totalArea += circle.getArea();
                    
            } else if (shape instanceof Cube) {
                Cube cube = (Cube) shape;
                info.append("Cube:\n")
                    .append("   Side: ").append(cube.getSide()).append("\n")
                    .append("   Area: ").append(String.format("%.2f", cube.getArea())).append("\n")
                    .append("   Volume: ").append(String.format("%.2f", cube.getVolume())).append("\n")
                    .append("   Color: ").append(cube.getColor()).append("\n");
                totalArea += cube.getArea();
            }
            
            info.append("   How to draw: ").append(shape.howToDraw()).append("\n\n");
        }
        
        info.append("=== Summary ===\n")
            .append("Total Shapes: ").append(shapes.size()).append("\n")
            .append("Total Area: ").append(String.format("%.2f", totalArea)).append("\n");
        
        infoArea.setText(info.toString());
        return infoArea;
    }
    
    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.BLUE);
            g.drawString("Shapes Drawing", 400, 40);
            
            g.setFont(new Font("Arial", Font.PLAIN, 14));
            g.setColor(Color.BLACK);
            
            int x = 50;  
            int y = 100;
            
            for (Drawable shape : shapes) {
                if (shape instanceof Circle) {
                    drawCircle(g, (Circle) shape, x, y);
                    x += 250;  
                    
                } else if (shape instanceof Cube) {
                    drawCube(g, (Cube) shape, x, y);
                    x += 300;
                }
                
                if (x > 800) {
                    x = 50;
                    y += 250;
                }
            }
        }
        
        private void drawCircle(Graphics g, Circle circle, int x, int y) {
            int radius = (int) Math.min(circle.getRadius(), 100);  
            
            Color shapeColor = getColorFromString(circle.getColor());
            g.setColor(shapeColor);
            g.fillOval(x, y, radius * 2, radius * 2);
            
            g.setColor(Color.BLACK);
            g.drawOval(x, y, radius * 2, radius * 2);
            
            g.drawString("Circle", x, y - 30);
            g.drawString("Radius: " + circle.getRadius(), x, y - 15);
            g.drawString("Area: " + String.format("%.2f", circle.getArea()), x, y + radius * 2 + 20);
        }
        
        private void drawCube(Graphics g, Cube cube, int x, int y) {
            int side = (int) Math.min(cube.getSide() * 5, 150);  
            
            Color shapeColor = getColorFromString(cube.getColor());
            g.setColor(shapeColor);
            
            int[] xPoints = {x, x + side, x + side + 20, x + 20};
            int[] yPoints = {y, y, y - 20, y - 20};
            
            g.fillPolygon(xPoints, yPoints, 4);
            
            g.fillRect(x, y, side, side);
            
            int[] sideX = {x + side, x + side + 20, x + side + 20, x + side};
            int[] sideY = {y, y - 20, y - 20 + side, y + side};
            g.fillPolygon(sideX, sideY, 4);
            
            g.setColor(Color.BLACK);
            g.drawRect(x, y, side, side);  
            g.drawPolygon(xPoints, yPoints, 4);  
            g.drawPolygon(sideX, sideY, 4);  
            
            g.drawLine(x, y, x + 20, y - 20);
            g.drawLine(x + side, y, x + side + 20, y - 20);
            g.drawLine(x, y + side, x + 20, y - 20 + side);
            
            g.drawString("Cube", x, y - 40);
            g.drawString("Side: " + cube.getSide(), x, y - 25);
            g.drawString("Area: " + String.format("%.2f", cube.getArea()), x, y + side + 20);
            g.drawString("Volume: " + String.format("%.2f", cube.getVolume()), x, y + side + 35);
        }
        
        private Color getColorFromString(String colorName) {
            switch (colorName.toLowerCase()) {
                case "red": return Color.RED;
                case "green": return Color.GREEN;
                case "blue": return Color.BLUE;
                case "yellow": return Color.YELLOW;
                case "orange": return Color.ORANGE;
                case "pink": return Color.PINK;
                case "cyan": return Color.CYAN;
                default: return Color.GRAY;
            }
        }
    }
    
    public static void showGUI(ArrayList<Drawable> shapes) {
        SwingUtilities.invokeLater(() -> {
            new ShapeGUI(shapes);
        });
    }
}