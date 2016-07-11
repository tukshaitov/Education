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
                latch.countDown();
                while (true) {
                    OrderStatus status = order.getStatus();
                    lock.writeLock().lock();

                    try {
                        int sleep = ThreadLocalRandom.current().nextInt(2000, 5000 + 1);
                        System.out.println("Before produce order we will wait: " + sleep / 1000 + " seconds.");
                        Thread.sleep(sleep);
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
        latch.await();

        OrderBroadcaster [] broadcasters = {
                new OrderBroadcaster(lock, order,  5000),
                new OrderBroadcaster(lock, order,  8000),
                new OrderBroadcaster(lock, order,  2000),
                new OrderBroadcaster(lock, order,  3000),
                new OrderBroadcaster(lock, order,  6000),
                new OrderBroadcaster(lock, order,  11000)
        };

        for(int i = 0; i < broadcasters.length; i++){
            new Thread(broadcasters[i], "broadcaster_" + i).start();
        }
    }
}
