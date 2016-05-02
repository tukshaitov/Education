package edu.pattern.gof.adapter;

/**
 * Created by Eldar on 11/8/2015.
 */
public class GoogleImageProcessor {
    private int x;
    private int y;
    private Image img;

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Image position x: " + x + " y: " + y);
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public int draw() {
        if (x < 0 || y < 0 || img == null) return x - y;
        else
            return 1;

    }
}
