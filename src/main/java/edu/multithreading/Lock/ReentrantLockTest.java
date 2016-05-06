package edu.multithreading.Lock;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Eldar on 4/17/2016.
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Order order = new Order();

    public static void main(String ... args){

        //region InitThread Start
        Thread initThread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                lock.lock();
                System.out.println("Holder count after lock: " + lock.getHoldCount());
                try {
                    int sleep = 5000;
                    System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                }
                finally {
                    lock.unlock();
                    lock.unlock();
                    System.out.println("Holder count after unlock: " + lock.getHoldCount() + ". This counter should be 0 for another thread can acquire this lock.");
                    //lock.unlock(); // Вызов метода в потоке для которого Holder Counter = 0 приводит к генерации исключения IllegalMonitorStateException.
                }
            }
        }, "Init");
        initThread.start();

        try {
            int sleep = 1000;
            System.out.println("Sleep:  " + sleep + " ensure that init thread starts.");
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
        }
        //endregion

        Thread withLockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    int sleep = 1000;
                    System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                }
                finally {
                    lock.unlock();
                }
            }
        }, "With Lock.lock()");
        withLockThread.start();

        Thread withTryLockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(lock.tryLock()) {
                    try {
                        int sleep = 1000;
                        System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                    } finally {
                        lock.unlock();
                    }
                }
                else {
                    System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " == false");
                }
            }
        }, "With Lock.tryLock()");
        withTryLockThread.start();

        Thread withTryLockTimeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(lock.tryLock(10, TimeUnit.SECONDS)) {
                        try {
                            int sleep = 1000;
                            System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        } finally {
                            lock.unlock();
                        }
                    }
                    else {
                        System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " == false");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method tryLock generates InterruptedException.");
                }
            }
        }, "With Lock.tryLock(long time, TimeUnit unit)");
        withTryLockTimeThread.start();

        Thread withlockInterruptiblyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                        try {
                            int sleep = 1000;
                            System.out.println("Execution Thread: " +  Thread.currentThread().getName() + " sleep: " + sleep);
                            Thread.sleep(sleep);
                        } catch (Exception e) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        } finally {
                            lock.unlock();
                        }
               } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " method lockInterruptibly generates InterruptedException.");
                }
            }
        }, "With Lock.lockInterruptibly()");
        withlockInterruptiblyThread.start();

        withLockThread.interrupt();
        withTryLockTimeThread.interrupt();
        withlockInterruptiblyThread.interrupt();

        try {
            int sleep = 10000;
            System.out.println("Sleep:  " + sleep + " before start Sender/Received threads.");
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
        }

        System.out.println("===========================");
        System.out.println("Test Lock Condition");

        lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();


        Thread sender = new Thread(new Runnable() {
            private int id = 0;
            @Override
            public void run() {
                MAIN: while (true) {

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
                        break;
                    }

                    lock.lock();
                    while(order.getStatus() == OrderStatus.SENT) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() +
                                    " method condition.await() generates InterruptedException. Thread isInterrupted: " + Thread.currentThread().isInterrupted());
                            lock.unlock();
                            break MAIN;
                        }
                    }
                    lock.unlock();

                    try {
                        int sleep = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
                        Thread.sleep(sleep);
                    }
                    catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        break;
                    }

                    lock.lock();
                    order.setId(id++);
                    order.setStatus(OrderStatus.SENT);
                    System.out.println("Order with number: " + order.getId() + " was sent.");
                    condition.signalAll();
                    lock.unlock();
                 }
            }
        }, "Sender");


        Thread receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                MAIN: while (true) {

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted.");
                        break;
                    }

                    lock.lock();
                    while(order.getStatus() == OrderStatus.NONE || order.getStatus() == OrderStatus.RECEIVED) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() +
                                    " method condition.await() generates InterruptedException. Thread isInterrupted: " + Thread.currentThread().isInterrupted());
                            lock.unlock();
                            break MAIN;
                        }
                    }
                    lock.unlock();

                    try {
                        int sleep = ThreadLocalRandom.current().nextInt(500, 3000 + 1);
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
                        break;
                    }

                    lock.lock();
                    order.setStatus(OrderStatus.RECEIVED);
                    System.out.println("Order with number: " + order.getId() + " was received.");
                    condition.signalAll();
                    lock.unlock();
                }
            }
        }, "Receiver");

        sender.start();
        receiver.start();

        try {
            int sleep = 2000;
            Thread.sleep(sleep);

            lock.lock();
            System.out.println("lock.getQueueLength(): " + lock.getQueueLength());
            System.out.println("lock.getWaitQueueLength(condition): " + lock.getWaitQueueLength(condition));
            System.out.println("lock.hasQueuedThread(sender): " + lock.hasQueuedThread(sender));
            System.out.println("lock.hasQueuedThread(receiver): " + lock.hasQueuedThread(receiver));
            System.out.println("lock.hasQueuedThreads(): " + lock.hasQueuedThreads());
            System.out.println("lock.hasWaiters(condition): " + lock.hasWaiters(condition));
            lock.unlock();

            sleep = 10000;
            System.out.println("Sleep:  " + sleep + " before complete Sender/Receiver threads.");
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " method sleep generates InterruptedException.");
        }

        System.out.println("lock.isHeldByCurrentThread(): " + lock.isHeldByCurrentThread());
        System.out.println("lock.isLocked(): " + lock.isLocked());

        sender.interrupt();
        receiver.interrupt();
        System.out.println("===========================");

    }
}

