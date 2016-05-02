package edu.pattern.gof.factorymethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Chainsaw implements Tool {
    @Override
    public void execute() {
        System.out.println("Chainsaw execute");
    }
}
