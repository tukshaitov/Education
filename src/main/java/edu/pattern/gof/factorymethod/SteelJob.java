package edu.pattern.gof.factorymethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class SteelJob implements Job {

    private Drill drill = new Drill();

    @Override
    public String getName() {
        return "Steel Job";
    }

    @Override
    public Tool getTool() {
        return drill;
    }
}
