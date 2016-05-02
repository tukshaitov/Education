package edu.pattern.gof.decorator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class FrameDecorator implements Shape{
    private int weight;
    private Color color;
    private Shape shape;

    public FrameDecorator(int weight, Color color, Shape shape) {
        this.weight = weight;
        this.color = color;
        this.shape = shape;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        this.shape.draw();
        System.out.println("Draw frame " + this.toString());
    }

    @Override
    public Point getLeftTopPoint() {
        Point point = new Point(this.shape.getLeftTopPoint().getX() - this.weight, this.shape.getLeftTopPoint().getY() - weight);
        return point;
    }

    @Override
    public Size getSize() {
        Size size = new Size(this.shape.getSize().getHeight() + 2 * this.weight, this.shape.getSize().getWidth() + 2 * weight);
        return size;
    }

    @Override
    public String toString() {
        return "FrameDecorator{" +
                "weight=" + weight +
                ", color=" + color +
                ", shape=" + shape +
                '}';
    }
}
