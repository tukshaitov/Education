package edu.pattern.gof.chainofresponsibility;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Handler */
abstract class Logger {
    private Logger nextLogger;
    private LoggerLevel loggerLevel;

    protected Logger(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public Logger setNextLoger(Logger next) {
        this.nextLogger = next;
        return this.nextLogger;
    }

    public final void log(String logRecord, LoggerLevel loggerLevel) {

        switch (loggerLevel) {
            case INFO:
                if (this.loggerLevel == LoggerLevel.INFO) write(logRecord);
                break;
            case WARN:
                if (this.loggerLevel != LoggerLevel.INFO) write(logRecord);
                break;
            case ERROR:
                write(logRecord);
                break;
        }

        if (nextLogger != null) {
            nextLogger.log(logRecord, loggerLevel);
        }
    }

    protected abstract boolean write(String logRecord);
}
