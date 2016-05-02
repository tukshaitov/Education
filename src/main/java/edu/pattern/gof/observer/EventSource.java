package edu.pattern.gof.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Observer pattern is used when there is one to many relationship between objects such as if
 * one object is modified, its depenedent objects are to be notified automatically. Observer pattern
 * falls under behavioral pattern category.
 */
public class EventSource extends Observable implements Runnable, CustomObservable {
    private int upper;
    private int lower;
    private List<CustomObserver> observerList = new ArrayList<>();

    EventSource(int upper, int lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public void addCustomObserver(CustomObserver customObserver) {
        observerList.add(customObserver);
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public void run() {
        while (true) {
            int r = (int) (Math.random() * (upper - lower)) + lower;
            this.setChanged();
            notifyObservers(r);
            notifyCustomObservers(r);

            try {
                Thread.currentThread().sleep(500);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void notifyCustomObservers(int randomValue) {
        for (CustomObserver customObserver : observerList)
            customObserver.attach(randomValue);
    }
}
