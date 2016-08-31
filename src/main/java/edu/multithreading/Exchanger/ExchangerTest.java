package edu.multithreading.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by eitukshaitov on 26.08.2016.
 */
public class ExchangerTest {
    public static void main (String ... args) throws InterruptedException {
        final Exchanger<Integer> exchanger = new Exchanger<>();
        ExchangerRunnable runnableOne = new ExchangerRunnable(exchanger, 9999);
        ExchangerRunnable runnableTwo = new ExchangerRunnable(exchanger, 7777);

        Thread firstThread = new Thread(runnableOne, "First Thread");
        firstThread.start();
        new Thread(runnableTwo, "Second Thread").start();    }
}
