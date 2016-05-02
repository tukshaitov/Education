package edu.pattern.gof.chainofresponsibility;

/**
 * Created by Eldar on 11/8/2015.
 */
public class WarnLog extends Logger {
    WarnLog() {
        super(LoggerLevel.WARN);
    }

    @Override
    protected boolean write(String logRecord) {
        System.out.println("WarnLog: " + logRecord);
        return false;
    }
}
