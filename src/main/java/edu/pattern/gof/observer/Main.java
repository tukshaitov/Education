package edu.pattern.gof.observer;

/**
 * Created by Eldar on 9/27/2015.
 */

public class Main {
    public static void main(String... args) {
        EventSource eventSource = new EventSource(0, 10);
        eventSource.addObserver(new ResponseHandlerOne());
        eventSource.addObserver(new ResponseHandlerTwo());
        eventSource.addCustomObserver(new CustomResponseHandler());
        new Thread(eventSource).start();

    }
}


