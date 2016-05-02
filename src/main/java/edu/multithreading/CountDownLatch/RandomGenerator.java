package edu.multithreading.CountDownLatch;

/**
 * Created by Eldar on 3/29/2016.
 */
public class RandomGenerator {
    public static long getRandom(long min, long max) {
        return min + (long)(Math.random() * (max - min + 1));
    }
}
