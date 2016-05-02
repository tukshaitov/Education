package edu.pattern.gof.memento;

/**
 * Memento  pattern  is  used  to  reduce  where  we  want  to  restore  state  of  an  object  to  a
 * previous state. Memento pattern falls under behavioral pattern category.
 * Without violating encapsulation, capture and externalize an object’s internal state so that the object
 * can be restored to this state later.
 * Also Known As Token

 */

public class Main {
    public static void main(String... args) {
        GraphicContext graphicContext = new GraphicContext();
        SpreadSheet sheet = new SpreadSheet(graphicContext);
        CareTaker careTaker = new CareTaker(sheet);

        SpreadSheet.Cell cell00 = sheet.getCell(0, 0);
        cell00.setValue("Hello");
        cell00.setColor(Color.GREEN);
        System.out.println("Value: '" + cell00.getValue() + "' color: " + cell00.getColor());

        careTaker.save();

        cell00.setValue("Hello World");
        cell00.setColor(Color.ORANGE);
        System.out.println("Value: '" + cell00.getValue() + "' color: " + cell00.getColor());
        careTaker.save();

        SpreadSheet.Cell cell01 = sheet.getCell(0, 1);
        cell01.setValue("My Love is Dangerous.");
        careTaker.save();

        cell01.setValue("Show Must Go On.");
        careTaker.save();

        careTaker.undo();
        System.out.println("Value 00: '" + cell00.getValue() + "' color: " + cell00.getColor());
        System.out.println("Value 01: '" + cell01.getValue() + "' color: " + cell01.getColor());
    }
}

