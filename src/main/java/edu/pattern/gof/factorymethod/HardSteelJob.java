package edu.pattern.gof.factorymethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class HardSteelJob implements Job {

    private Tool steelMachine = new Tool() {
        @Override
        public void execute() {
            System.out.println("HardSteelMachine execute");
        }
    };

    @Override
    public String getName() {
        return "Hard Steel Job";
    }

    @Override
    public Tool getTool() {
        return steelMachine;
    }
}
