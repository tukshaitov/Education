package edu.pattern.gof.composite;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Element implements CommonNode {

    private int cost;

    public Element(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String getText() {
        return "Element with cost";
    }
}
