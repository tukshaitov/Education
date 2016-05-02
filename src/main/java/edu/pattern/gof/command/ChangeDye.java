package edu.pattern.gof.command;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ChangeDye implements Command {
    private Printer printer;

    ChangeDye(Printer printer) {
        this.printer = printer;
    }


    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.changeDye();
    }
}
