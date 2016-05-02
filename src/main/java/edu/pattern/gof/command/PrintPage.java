package edu.pattern.gof.command;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Command Object, routed event args, event object */
public class PrintPage implements Command {
    private Printer printer;
    private Page page;

    PrintPage(Printer printer, Page page) {
        this.printer = printer;
        this.page = page;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public void execute() {
        printer.print(page);
    }
}
