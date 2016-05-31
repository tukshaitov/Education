package edu.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldar on 5/5/2016.
 */
public class ThreadStateTest {

    private static Object mutex = new Object();

    public static void main(String ... args){
        List<Thread> threadList = new ArrayList<Thread>();
        for(int i = 1; i <= 5; i++){
            Thread thread = new Thread(new Wait(), "thread_" + i);
            threadList.add(thread);
            thread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Thread thread : threadList){
            System.out.println("State of " + thread.getName() + " is: " + thread.getState());
        }
        System.out.println("Send notify all.");
        synchronized (mutex) {
            mutex.notifyAll();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Thread thread : threadList){
            System.out.println("State of " + thread.getName() + " is: " + thread.getState());
        }

    }

    private static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized (mutex){
                try {
                    mutex.wait();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " is working.");
            }
        }
    }
}

