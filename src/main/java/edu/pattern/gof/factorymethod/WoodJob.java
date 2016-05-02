package edu.pattern.gof.factorymethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class WoodJob implements Job {
    private Chainsaw chainsaw = new Chainsaw();

    @Override
    public String getName() {
        return "Wood Job";
    }

    @Override
    public Tool getTool() {
        return chainsaw;
    }
}
