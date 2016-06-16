package edu.multithreading.Lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by eitukshaitov on 02.05.2016.
 */
public class ReentrantReadWriteLockTest {
    private static volatile ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    private static Condition condition;
    private static Order order = new Order();

    public static void main(String ... args){

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();  // Использовать read lock и write lock condition нельзя.
                try {
                    condition.await(2, TimeUnit.SECONDS);
                    System.out.println("Condition test OK.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.writeLock().unlock();
            }
        }).start();*/


        Thread orderFactory = new Thread(new Runnable() {
            private int id = 0;
            @Override
            public void run() {

                while (true) {
                    OrderStatus status = order.getStatus();
                    lock.writeLock();

                    try {
                        System.out.println("Before produce order.");
                        int sleep = ThreadLocalRandom.current().nextInt(2000, 5000 + 1);
                        Thread.sleep(sleep);
                        order.setId(id++);
                        order.setStatus(OrderStatus.SENT);
                        System.out.println("Order with number: " + order.getId() + " was sent.");
                        condition.signalAll();
                    }
                    catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        break;
                    }
                    finally {
                        lock.writeLock();
                    }
                }
            }
        }, "OrderFactory");
    }
}
