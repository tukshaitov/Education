package edu.pattern.gof.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Command Manager, Undo Manager, Scheduler, Queue, Dispatcher, Invoker */
public class CommandInvoker {
    private List<Command> history = new ArrayList<Command>();

    public CommandInvoker() {
    }

    public void storeAndExecute(Command cmd) {
        this.history.add(cmd); // optional
        cmd.execute();
    }
}
