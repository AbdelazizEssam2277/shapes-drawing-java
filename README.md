# Shapes Drawing Application (Java)

A Java OOP course project that models geometric shapes, reads them from a text file, and displays them in a Swing window.

## Features
- Class hierarchy of 7 classes: 2 abstract classes (`Shape`, `ThreeDShape`), 1 interface (`Drawable`), 2 concrete shapes (`Circle`, `Cube`)
- Inheritance, polymorphism and abstraction
- Reads shapes from `input.txt`, computes the total area, and writes a report to `sumAreas.txt`
- Swing GUI that draws the shapes and shows each shape's area, perimeter and volume

## Input Format
One shape per line, a type followed by one number, for example `circle 22.5` or `cube 23.6`.

## Tech Stack
Java, OOP, Swing

## How to Run
Requires JDK 8 or later. From the project folder (the one containing `src` and `input.txt`):

    javac -d build/classes src/*.java
    java -cp build/classes Main

## Notes
Individual project for the Object-Oriented Programming course, Faculty of Computers and Information, Assiut University (Dec 2025).
