package edu.multithreading.Lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by eitukshaitov on 03.05.2016.
 */
public class OrderBroadcaster implements Runnable {
    private ReadWriteLock lock;
    private Order order;
    private int sleepTime;

    @Override
    public void run() {
        while (true) {
            lock.readLock().lock();
            try {
                Thread.sleep(sleepTime);
                System.out.println("Broadcaster " + Thread.currentThread().getName() + " send order with id " + order.getId() +".");
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
            } finally {
                lock.readLock().unlock();
                break;
            }
        }
    }
}
