package edu.multithreading.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by eitukshaitov on 30.08.2016.
 */
public class SemaphoreTest {
    public static void main(String ... args) throws InterruptedException {
        //Semaphore semaphore = new Semaphore(1);
        //new Worker(semaphore, "Adder", true).start();
        //new Worker(semaphore, "Reducer", false).start();

        Semaphore semaphore = new Semaphore(2, true);

        Thread firstThread = new Thread(new AcquireJob(semaphore, 5), "First");
        firstThread.start();
        printAvailablePermits(firstThread, semaphore);

        System.out.println(semaphore.tryAcquire());
        System.out.println(semaphore.tryAcquire(0, TimeUnit.SECONDS));

        Thread secondThread = new Thread(new AcquireJob(semaphore, 1), "Second");
        secondThread.start();
        printAvailablePermits(secondThread, semaphore);

        Thread thirdThread = new Thread(new AcquireJob(semaphore, 1), "Third");
        thirdThread.start();
        printAvailablePermits(thirdThread, semaphore);

        Thread fourthThread = new Thread(new AcquireJob(semaphore, 2), "Fourth");
        fourthThread.start();
        printAvailablePermits(fourthThread, semaphore);

        semaphore.release(7);



        printAvailablePermits(fourthThread, semaphore);

//        Thread fifthThread = new Thread(new AcquireJob(semaphore, 2), "Fifth");
//        fifthThread.start();
//        printAvailablePermits(fifthThread, semaphore);
    }

    private static void printAvailablePermits(Thread thread, Semaphore semaphore){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Available Permits after " + thread.getName() + " start: " + semaphore.availablePermits());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AcquireJob implements Runnable {
    private Semaphore semaphore;
    private int permits;

    public AcquireJob(Semaphore semaphore, int permits) {
        this.semaphore = semaphore;
        this.permits = permits;
    }

    @Override
    public void run() {
        try {
            this.semaphore.acquire(this.permits);
            System.out.println("Thread " + Thread.currentThread().getName() + " completed. Semaphore was acquired. Available Permits: " + this.semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
