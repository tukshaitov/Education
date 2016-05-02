package edu.multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Created by Eldar on 3/29/2016.
 */
public class Worker extends Thread {

    private CountDownLatch cdl;
    private String name;

    public Worker (CountDownLatch cdl, String name) {
        this.cdl = cdl;
        this.name = name;
    }

    @Override
    public void run() {
        Stopwatch sw = Stopwatch.createUnstarted();
        sw.start();

        System.out.println(name + " working...");
        try {
            Thread.sleep(RandomGenerator.getRandom(500, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
        if(this.name.equals("Sand"))
            cdl.countDown();

        cdl.countDown();

        sw.stop();
        System.out.println(name + " time: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}