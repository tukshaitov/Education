package edu.pattern.gof.command;

/**
 * Created by Eldar on 11/8/2015.
 */
public class TurnOn implements Command {
    private Printer printer;
    private boolean commandResult;

    TurnOn(Printer printer) {
        this.printer = printer;

    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public boolean isCommandResult() {
        return commandResult;
    }

    @Override
    public void execute() {
        commandResult = printer.turnOn();
    }
}
