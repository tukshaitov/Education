package edu.pattern.gof.decorator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Circle implements Shape {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw " + this.toString());
    }

    @Override
    public Point getLeftTopPoint() {
        return new Point(this.center.getX() - radius, this.center.getY() - radius);
    }

    @Override
    public Size getSize() {
        return new Size(this.radius *2, this.radius* 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
