package edu.multithreading.Lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;


public class OrderBroadcaster implements Runnable {
    private ReadWriteLock lock;
    private Order order;
    private int sleepTime;

    public OrderBroadcaster(ReadWriteLock lock, Order order, int sleepTime) {
        this.lock = lock;
        this.order = order;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while (true) {
            lock.readLock().lock();
            System.out.println("Checking....");
            try {
                Thread.sleep(sleepTime);
                System.out.println("Broadcaster " + Thread.currentThread().getName() + " displayed order with id " + order.getId() +".");
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
                break;
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
