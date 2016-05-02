package edu.pattern.gof.observer;

/**
 * Created by Eldar on 11/8/2015.
 */
public class CustomResponseHandler implements CustomObserver {
    @Override
    public void attach(int randomValue) {
        System.out.println("This is CustomResponseHandler and value is " + randomValue);
    }
}
