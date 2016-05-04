package edu.multithreading.Lock;

import java.util.concurrent.ThreadLocalRandom;
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

        Lock writeLock = lock.writeLock();
        condition = writeLock.newCondition();

        Thread sender = new Thread(new Runnable() {
            private int id = 0;
            @Override
            public void run() {

                while (true) {
                    if(Thread.currentThread().isInterrupted()){
                        writeLock.unlock();
                        System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
                        break;
                    }

                    OrderStatus status = order.getStatus();
                    while(status == OrderStatus.SENT) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " method condition.await() generates InterruptedException.");
                            writeLock.unlock();
                            break;
                        }
                    }
                    try {
                        System.out.println("Before sending order");
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
                        writeLock.unlock();
                    }
                }
            }
        }, "Sender");
    }
}
