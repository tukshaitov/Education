package edu.pattern.gof.decorator;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface Shape {
    void draw();
    Point getLeftTopPoint();
    Size getSize();
}
