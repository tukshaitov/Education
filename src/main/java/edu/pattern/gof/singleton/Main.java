package edu.pattern.gof.singleton;

/**
 * Ensure a class only has one instance, and provide a global point of access to it.
 */

public class Main {
    public static void main(String... args) {
        System.out.println(SingletonObject.getAnotherSingleton(100));
        System.out.println(SingletonObject.getAnotherSingleton(50));

        System.out.println(SingletonObject.getSingleton(50));
        System.out.println(SingletonObject.getSingleton(100));

    }
}

