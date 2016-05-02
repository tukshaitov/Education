package edu.pattern.gof.command;

/**
 * Created by Eldar on 9/27/2015.
 * Command pattern
 * Also Known As Action, Transaction
 */

/* Client, Source, Invoker */
public class Main {
    public static void main(String... str) {
        Page page = new Page(5);
        Printer printer = new Printer();
        //Command[] commands = {new TurnOn(printer), new PrintPage(printer, page), new ChangeDye(printer), new PrintString(printer, "Hello world"), new TurnOff(printer)};
        //for (Command command : commands)
        //    command.execute();

        CommandInvoker invoker = new CommandInvoker();
        invoker.storeAndExecute(new TurnOn(printer));
    }
}


