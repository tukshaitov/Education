package edu.pattern.gof.iterator;

import java.util.Iterator;

/**
 * Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
 *
 * Also Known As Cursor
 *
 */

public class Main {
    public static void main(String... args) {
        Order order = new Order(new Sofa(), new Cupboard(), new Bed());
        Iterator<Furniture> iterator = order.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

