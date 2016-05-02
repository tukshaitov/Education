package edu.pattern.gof.templatemethod;

/**
 * Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm’s structure.
 */

public class Main {
    public static void main(String... args) {
        Meat meat = new Fish();
        meat.dish();
    }
}

