package edu.pattern.gof.decorator;

/**
 * Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
 * Also Known As Wrapper
 */
public class Main {
    public static void main(String... args) {
        Shape rectangle = new Rectangle(new Point(10, 10), new Size(30, 30));
        FrameDecorator decorator = new FrameDecorator(3, Color.BLUE, rectangle);
        decorator.draw();

    }
}




