package edu.pattern.gof.prototype;

/**
 * Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.
 */

public class Main {
    public static void main(String ... args){
        Motor motor = new Motor(10, 1);
        Car car = new Car(motor, 5, Side.Left);
        Car clone = car.clone();
        System.out.println("car == clone is: " + (car == clone));
        System.out.println("motor == clone is: " + (motor == clone.getMotor()));

    }
}
