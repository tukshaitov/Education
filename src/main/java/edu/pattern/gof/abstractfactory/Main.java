package edu.pattern.gof.abstractfactory;

/**
 * Abstract Factory patterns works around a super-factory which creates other factories. This
 * factory is also called as Factory of factories. This type of design pattern comes under creational
 * pattern.Provide an interface for creating families of related or dependent objects without
 * specifying their concrete classes. Another name is Kit.
 *
 */
public abstract class Main {
    public static Main newFactory(GraphicType graphicType) {
        switch (graphicType) {
            case CENTOS:
                return new CentosFactory();
            case MAC:
                return new MacFactory();
            default:
                return new MacFactory();
        }
    }

    public static void main(String... args) {
        Main factory = new MacFactory();
        factory.createButton().draw();
        factory.createGrid().draw();

        System.out.println("------------------------------");

        factory = new CentosFactory();
        factory.createButton().draw();
        factory.createGrid().draw();
    }

    public abstract Button createButton();

    public abstract Grid createGrid();
}


