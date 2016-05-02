package edu.multithreading.CountDownLatch;

import com.google.common.base.Stopwatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eldar on 3/29/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = Stopwatch.createUnstarted();
        sw.start();

        CountDownLatch latch = new CountDownLatch(5);

        new Worker(latch,"Sand").start();
        new Worker(latch,"Cement").start();
        new Worker(latch,"Water").start();
        new Worker(latch,"Breakstone").start();

        System.out.println("Waiting for all workers");
        latch.await();
        System.out.println("All workers finished. Now we can shake.");

        sw.stop();
        System.out.println("Program time: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}
