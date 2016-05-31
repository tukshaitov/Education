package edu.multithreading.Lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by eitukshaitov on 03.05.2016.
 */
public class OrderReceiver implements Runnable {
    private Lock readLock;
    private Order order;
    private int sleep;

    public OrderReceiver() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        while (true) {
            readLock.lock();

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                readLock.unlock();
                return;
            }

            if(Thread.currentThread().isInterrupted()){
                readLock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
                break;
            }
            OrderStatus status = order.getStatus();
           /* while(status == OrderStatus.NONE || status == OrderStatus.RECEIVED) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method condition.await() generates InterruptedException.");
                    lock.unlock();
                    break;
                }
            }
            try {
                int sleep = ThreadLocalRandom.current().nextInt(500, 3000 + 1);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                    break;
                }

                order.setStatus(OrderStatus.RECEIVED);
                System.out.println("Order with number: " + order.getId() + " was received.");
                condition.signalAll();
            } finally {
                lock.unlock();
            }*/
        }
    }
}
