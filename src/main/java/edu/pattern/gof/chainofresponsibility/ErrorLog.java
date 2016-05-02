package edu.pattern.gof.chainofresponsibility;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ErrorLog extends Logger {
    ErrorLog() {
        super(LoggerLevel.ERROR);
    }

    @Override
    protected boolean write(String logRecord) {
        System.out.println("ErrorLog: " + logRecord);
        return false;
    }
}
