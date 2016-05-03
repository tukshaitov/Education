package edu.multithreading.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by eitukshaitov on 02.05.2016.
 */
public class ReentrantReadWriteLockTest {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String ... args){
        //region InitThread Start
        Thread writerThreadFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                //lock.lock();
                //System.out.println("Holder count after lock: " + lock.getHoldCount());
                try {
                    int sleep = 5000;
                    System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                }
                finally {
                    //lock.unlock();
                    //lock.unlock();
                    //System.out.println("Holder count after unlock: " + lock.getHoldCount() + ". This counter should be 0 for another thread can acquire this lock.");
                    //lock.unlock(); // Вызов метода в потоке для которого Holder Counter = 0 приводит к генерации исключения IllegalMonitorStateException.
                }
            }
        }, "Init");
        writerThreadFirst.start();
    }
}
