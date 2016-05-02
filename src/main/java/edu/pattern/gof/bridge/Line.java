package edu.pattern.gof.bridge;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Line extends Shape {
    private int fromX;
    private int fromY;
    private int toX;
    private int toY;
    private int color;

    Line(ShapeIml shapeIml, int fromX, int fromY, int toX, int toY, int color) {
        super(shapeIml);
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.color = color;
    }

    public int getFromX() {
        return fromX;
    }

    public int getFromY() {
        return fromY;
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }

    public int getColor() {
        return color;
    }

    @Override
    public void draw() {
        double tgx = (this.toY - this.fromY) / (this.toX - this.fromX);
        double b = this.fromY - tgx * this.fromX;
        for (int x = this.fromX; x <= this.toX; x++) {
            int y = (int) (tgx * x + b);
            shapeIml.drawPix(x, y, color);
        }
    }
}
