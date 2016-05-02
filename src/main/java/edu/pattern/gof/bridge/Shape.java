package edu.pattern.gof.bridge;

/**
 * Created by Eldar on 11/8/2015.
 */
abstract class Shape {
    protected ShapeIml shapeIml;

    protected Shape(ShapeIml shapeIml) {
        this.shapeIml = shapeIml;
    }

    public abstract void draw();
}
