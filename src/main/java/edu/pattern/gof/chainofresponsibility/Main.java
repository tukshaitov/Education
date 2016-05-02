package edu.pattern.gof.chainofresponsibility;

/**
 * Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.
 * Chain the receiving objects and pass the request along the chain until an object handles it.
 * This pattern comes under behavioral patterns.
 */
public class Main {
    public static void main(String... args) {
        Logger logger = new InfoLog();
        logger.setNextLoger(new ErrorLog()).setNextLoger(new WarnLog());
        logger.log("Test", LoggerLevel.INFO);
        logger.log("Hello", LoggerLevel.WARN);
        logger.log("World", LoggerLevel.ERROR);
    }
}

