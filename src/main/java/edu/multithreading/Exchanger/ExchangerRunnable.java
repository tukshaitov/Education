package edu.multithreading.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by eitukshaitov on 26.08.2016.
 */
public class ExchangerRunnable implements Runnable{

    Exchanger<Integer> exchanger = null;
    Integer    value    = null;

    public ExchangerRunnable(Exchanger<Integer> exchanger, Integer value) {
        this.exchanger = exchanger;
        this.value = value;
    }

    public void run() {
        try {
            Integer previous = this.value;

            this.value = this.exchanger.exchange(this.value);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged previous: " + previous + " for current:" + this.value
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}