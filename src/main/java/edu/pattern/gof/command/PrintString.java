package edu.pattern.gof.command;

/**
 * Created by Eldar on 11/8/2015.
 */
public class PrintString implements Command {
    private Printer printer;
    private String string;

    PrintString(Printer printer, String string) {
        this.printer = printer;
        this.string = string;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public void execute() {
        printer.print(string);
    }
}
