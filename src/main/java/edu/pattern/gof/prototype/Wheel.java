package edu.pattern.gof.prototype;

/**
 * Created by Eldar on 11/16/2015.
 */
public class Wheel implements Cloneable {
    private int size;
    private Side side;

    public Wheel(int size, Side side) {
        this.size = size;
        this.side = side;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Wheel clone(){
        try {
            return (Wheel)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
