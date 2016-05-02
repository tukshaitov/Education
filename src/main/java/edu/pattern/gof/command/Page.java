package edu.pattern.gof.command;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Page {
    private int number;

    public Page(int number) {
        this.number = number;
    }

    public String toString() {
        return "? " + this.number;
    }
}
