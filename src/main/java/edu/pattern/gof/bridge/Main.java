package edu.pattern.gof.bridge;

/**
 * Decouple an abstraction from its implementation so that the two can vary independently.
 *
 * Also Known As Handle/Body
 */

public class Main {
    public static void main(String... args) {
        MonitorShapeImpl shapeImpl = new MonitorShapeImpl();
        Shape shape = new Line(shapeImpl, 1, 5, 4, 8, 10);
        shape.draw();
    }
}


