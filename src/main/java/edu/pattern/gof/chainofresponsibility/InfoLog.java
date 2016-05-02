package edu.pattern.gof.chainofresponsibility;

/**
 * Created by Eldar on 11/8/2015.
 */
public class InfoLog extends Logger {
    InfoLog() {
        super(LoggerLevel.INFO);
    }

    @Override
    protected boolean write(String logRecord) {
        System.out.println("InfoLog: " + logRecord);
        return false;
    }
}
