package edu.pattern.gof.decorator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Rectangle implements Shape{
    private Point leftTopPoint;
    private Size size;

    public Rectangle(Point leftTopPoint, Size size) {
        this.leftTopPoint = leftTopPoint;
        this.size = size;
    }

    @Override
    public Point getLeftTopPoint() {
        return leftTopPoint;
    }

    public void setLeftTopPoint(Point leftTopPoint) {
        this.leftTopPoint = leftTopPoint;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "leftTopPoint=" + leftTopPoint +
                ", size=" + size +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Draw " + this.toString());
    }

    @Override
    public Size getSize() {
        return this.size;
    }
}