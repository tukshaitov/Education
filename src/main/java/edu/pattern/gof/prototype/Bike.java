package edu.pattern.gof.prototype;

/**
 * Created by Eldar on 11/16/2015.
 */
public class Bike extends Vehicle implements Cloneable{

    private BrakeType brakeType;
    private Boolean hasWings;
    private Integer numberOfSpeeds;

    public Bike(BrakeType brakeType, Boolean hasWings, Integer numberOfSpeeds) {
        this.brakeType = brakeType;
        this.hasWings = hasWings;
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }

    public Boolean getHasWings() {
        return hasWings;
    }

    public void setHasWings(Boolean hasWings) {
        this.hasWings = hasWings;
    }

    public Integer getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(Integer numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

    @Override
    public void drive() {

    }

    public Bike clone(){
        try {
            return (Bike)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
