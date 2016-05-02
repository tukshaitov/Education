package edu.pattern.gof.builder;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ConcreteBuilderTwo extends AbstractBuilder {

    public ConcreteBuilderTwo() {
        product = new Product();
    }

    @Override
    public ConcreteBuilderTwo buildCountry(String country) {
        if (country == null)
            product.setCountry("Azerbaijan");
        else
            product.setCountry(country);

        return this;
    }

    @Override
    public ConcreteBuilderTwo buildName(String name) {
        if (name == null || name.length() > 10)
            product.setName("Mercedes");
        else
            product.setName(name);
        return this;
    }

    @Override
    public boolean setAge(int age) {
        product.setAge(age);
        return true;
    }

    @Override
    public void setPrice(int price) throws IllegalArgumentException {
        if (price < 0)
            new IllegalArgumentException();
        else
            product.setPrice(price);
    }
}
