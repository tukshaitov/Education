package edu.pattern.gof.prototype;

/**
 * Created by Eldar on 11/16/2015.
 */
public class Motor implements Cloneable {
    private int power;
    private int fuelRate;

    public Motor(int power, int fuelRate) {
        this.power = power;
        this.fuelRate = fuelRate;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(int fuelRate) {
        this.fuelRate = fuelRate;
    }

    @Override
    protected Motor clone() {
        try {
            return (Motor)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
