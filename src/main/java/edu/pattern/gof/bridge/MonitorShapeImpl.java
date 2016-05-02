package edu.pattern.gof.bridge;

/**
 * Created by Eldar on 11/8/2015.
 */
public class MonitorShapeImpl implements ShapeIml {
    @Override
    public void drawPix(int x, int y, int color) {
        System.out.println("Monitor draws pix: x=" + x + " y=" + y + " color=" + color);
    }
}
