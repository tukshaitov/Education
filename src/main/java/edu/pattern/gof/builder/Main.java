package edu.pattern.gof.builder;

/**
 *  Separate the construction of a complex object from its representation so that the same construction process can create different representations.
 *  This type of design pattern comes under creational pattern as this pattern
 */
public class Main {
    public static void main(String... args) {
        System.out.println("GoF Builder Pattern Test");
        Director director = new Director(new ConcreteBuilderOne());
        try {
            director.construct("Notebook", "Japan", 25, 50);
            System.out.println(director.getProcuct());
        } catch (ProductBuildException e) {
            e.printStackTrace();
        }
    }
}

