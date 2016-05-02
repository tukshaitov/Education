package edu.pattern.gof.mediator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Screen {
    private int value;

    public Screen(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
