package edu.pattern.gof.builder;

/**
 * Created by Eldar on 11/8/2015.
 */
public abstract class AbstractBuilder {

    protected Product product;

    public Product getProduct() throws ProductBuildException {
        return this.product;
    }

    public void createNewProduct() {
        this.product = new Product();
    }

    public abstract AbstractBuilder buildCountry(String country);

    public abstract AbstractBuilder buildName(String name);

    public abstract boolean setAge(int age);

    public abstract void setPrice(int price) throws IllegalArgumentException;

}
