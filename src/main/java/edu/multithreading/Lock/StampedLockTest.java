package edu.multithreading.Lock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by Eldar on 7/26/2016.
 */
public class StampedLockTest {
    private static StampedLock stampedLock = new StampedLock();
    public static void main(String ... args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                long stamp = stampedLock.readLock();
                System.out.println("First read_" + stamp);
                stampedLock.unlockRead(stamp);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long stamp = stampedLock.readLock();
                //long lastStamp = 0;
                //for (int i = 0; i <= 1000; i++) {
                //    lastStamp = stampedLock.readLock();
                //}
                System.out.println("Second read_" + stamp);
                //System.out.println("Last stamp_" + lastStamp);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stampedLock.unlockRead(stamp);
                //for (int i = 0; i <= 1000; i++) {
                //    stampedLock.unlockRead(stamp);
                //}
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long stamp = stampedLock.writeLock();
                System.out.println("First write_" + stamp);
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stampedLock.unlockWrite(stamp);
            }
        }).start();


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //long stamp = stampedLock.writeLock();
        //System.out.println("Second write_" + stamp);
        System.out.println("Try to convert_" + stampedLock.tryConvertToWriteLock(384));

        long stamp = stampedLock.writeLock();
        stampedLock.unlock(stamp);
    }
}
