package edu.pattern.gof.templatemethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Pork extends Meat {
    @Override
    protected int buy() {
        System.out.println("Buy Pork");
        return 100;
    }

    @Override
    protected void prepare() {
        System.out.println("Prepare Pork");
    }

    @Override
    protected void fry() {
        System.out.println("Fry Pork");
    }
}
