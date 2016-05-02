package edu.pattern.gof.prototype;

/**
 * Created by Eldar on 11/16/2015.
 */
public class Car extends Vehicle implements Cloneable {

    private Motor motor;
    private int numberOfDoors;
    private Side rudderSide;

    public Car(Motor motor, int numberOfDoors, Side rudderSide) {
        this.motor = motor;
        this.numberOfDoors = numberOfDoors;
        this.rudderSide = rudderSide;
        this.addWheel(new Wheel(30, Side.Left));
        this.addWheel(new Wheel(30, Side.Left));
        this.addWheel(new Wheel(30, Side.Right));
        this.addWheel(new Wheel(30, Side.Right));
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Side getRudderSide() {
        return rudderSide;
    }

    public void setRudderSide(Side rudderSide) {
        this.rudderSide = rudderSide;
    }

    @Override
    public void drive() {

    }

    public Car clone() {
        try {
            Car car = (Car) super.clone();
            car.motor = motor.clone();
            return car;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
