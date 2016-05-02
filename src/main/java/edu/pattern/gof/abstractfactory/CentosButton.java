package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public class CentosButton implements Button {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Draw Centos Button");
    }
}
