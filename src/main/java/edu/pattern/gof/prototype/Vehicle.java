package edu.pattern.gof.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldar on 11/16/2015.
 */
public abstract class Vehicle {
    private List<Wheel> wheelList = new ArrayList<>();
    private int weight;
    private int width;
    private int length;
    private int height;
    private boolean hasEngine;
    private int carrying;
    private int maxSpeed;

    public List<Wheel> getWheelList() {
        return new ArrayList<>(wheelList);
    }

    protected void addWheel(Wheel wheel) {
        this.wheelList.add(wheel);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHasEngine() {
        return hasEngine;
    }

    protected void setHasEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public abstract void drive();

    @Override
    protected Vehicle clone() throws CloneNotSupportedException{
        Vehicle vehicle = (Vehicle) super.clone();
        vehicle.wheelList = new ArrayList<>();
        for(Wheel wheel : this.wheelList)
        vehicle.addWheel(wheel.clone());

        return vehicle;
    }
}
