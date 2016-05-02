package edu.pattern.gof.bridge;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Rectangle extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;
    private int color;

    Rectangle(ShapeIml shapeIml, int x, int y, int width, int height, int color) {
        super(shapeIml);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void draw() {
        for (int x = this.x; x <= this.width; x++)
            shapeIml.drawPix(x, y, this.color);

        int x = this.x + this.height;
        for (; x <= this.width; x++)
            shapeIml.drawPix(x, y, this.color);

        for (int y = this.y; y <= this.height; y++)
            shapeIml.drawPix(x, y, this.color);

        int y = this.y + this.width;
        for (; y <= this.height; y++)
            shapeIml.drawPix(x, y, this.color);
    }
}
