package edu.multithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by eitukshaitov on 03.05.2016.
 */
public class OrderReader implements Runnable {
    private ReadWriteLock lock;
    private Order order;

    public OrderReader() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try{
            while(true){

            }
        }
        finally {
            readLock.unlock();
        }

    }
}
