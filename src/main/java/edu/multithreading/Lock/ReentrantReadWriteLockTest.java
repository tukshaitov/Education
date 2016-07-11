package edu.multithreading.Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    private static volatile ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    private static volatile CountDownLatch latch = new CountDownLatch(1);
    private static Order order = new Order();

    public static void main(String ... args) throws InterruptedException {

        /*
        Condition condition = lock.writeLock().newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.readLock().lock();  // Использовать read lock и write lock condition нельзя.
                try {
                    condition.await(2, TimeUnit.SECONDS);
                    System.out.println("Condition test OK.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.readLock().unlock();
            }
        }).start();*/


        Thread orderFactory = new Thread(new Runnable() {
            private int id = 0;
            @Override
            public void run() {
                latch.countDown();
                while (true) {
                    try {
                        int sleep = ThreadLocalRandom.current().nextInt(500, 1000);
                        System.out.println("Before produce order we will wait: " + sleep / 1000 + " seconds.");
                        Thread.sleep(sleep);
                        lock.writeLock().lock();
                        order.setId(id++);
                        System.out.println("Order with number: " + order.getId() + " was factored.");
                    }
                    catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        break;
                    }
                    finally {
                        lock.writeLock().unlock();
                    }
                }
            }
        }, "OrderFactory");

        orderFactory.start();

        OrderBroadcaster [] broadcasters = {
                new OrderBroadcaster(lock, order,  500),
                new OrderBroadcaster(lock, order,  800),
                new OrderBroadcaster(lock, order,  200),
                new OrderBroadcaster(lock, order,  300),
                new OrderBroadcaster(lock, order,  600),
                new OrderBroadcaster(lock, order,  1100)
        };

        latch.await();

        for(int i = 0; i < broadcasters.length; i++){
            new Thread(broadcasters[i], "broadcaster_" + i).start();
        }
    }
}
