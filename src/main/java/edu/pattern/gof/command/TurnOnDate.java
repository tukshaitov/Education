package edu.pattern.gof.command;

import java.util.Date;

/**
 * Created by Eldar on 11/8/2015.
 */
public class TurnOnDate implements Command {
    private Printer printer;
    private Date date;
    private boolean commandResult;

    TurnOnDate(Printer printer, Date date) {
        this.printer = printer;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        commandResult = printer.turnOn(date);
    }
}
