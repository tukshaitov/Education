package edu.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by eitukshaitov on 16.08.2016.
 */
public class FixedThreadPoolTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String ... args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureList.add(executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Task: " + atomicInteger.incrementAndGet() +  " for Thread: " + Thread.currentThread().getName() + " is completed.");
                }
            }));
        }

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task: " + atomicInteger.incrementAndGet() +  " for Thread: " + Thread.currentThread().getName() + " is completed.");
            }
        });



    }
}
