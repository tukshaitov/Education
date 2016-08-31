package edu.multithreading.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by eitukshaitov on 30.08.2016.
 */
public class SemaphoreTest {
    public static void main(String ... args){
        //Semaphore semaphore = new Semaphore(1);
        //new Worker(semaphore, "Adder", true).start();
        //new Worker(semaphore, "Reducer", false).start();

        Semaphore semaphore = new Semaphore(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Thread " + Thread.currentThread().getName() + " completed. Semaphore was acquired. ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "First Thread").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Thread " + Thread.currentThread().getName() + " completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Second Thread.").start();


    }
}
