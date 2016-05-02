package edu.pattern.gof.strategy;

/**
* Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
* Also Known As Policy
*/

/* Client */
public class Main {
    public static void main(String... args) {
        CompressorContext context = new CompressorContext();
        context.setStr("Hello World");
        context.compressWayOne();

        context.setCompressor(new LZMACompressor(context));
        context.compressWayTwo();

        context.compressWayThree("Hello Universe");
    }
}

