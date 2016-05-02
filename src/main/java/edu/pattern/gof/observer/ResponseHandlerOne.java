package edu.pattern.gof.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ResponseHandlerOne implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if ((Integer) arg < 5)
            System.out.println("This is ObserverOne and value is " + arg);
    }
}
