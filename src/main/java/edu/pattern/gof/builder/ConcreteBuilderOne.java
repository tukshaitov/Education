package edu.pattern.gof.builder;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ConcreteBuilderOne extends AbstractBuilder {

    private String name;
    private int age;
    private boolean isAcceptable;
    private String country;
    private int price;

    public ConcreteBuilderOne() {
    }

    public ConcreteBuilderOne(String name, int age, boolean isAcceptable, String country, int price) {
        this.name = name;
        this.age = age;
        this.isAcceptable = isAcceptable;
        this.country = country;
        this.price = price;
    }

    @Override
    public ConcreteBuilderOne buildCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public ConcreteBuilderOne buildName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean setAge(int age) {
        if (age >= 100)
            return false;
        else
            this.age = age;
        return true;
    }

    @Override
    public void setPrice(int price) throws IllegalArgumentException {
        if (price < 0)
            new IllegalArgumentException();
        else
            this.price = price;
    }

    public Product getProduct() throws ProductBuildException {
        if (age > 60 && price > 100)
            throw new ProductBuildException();

        if (name == null)
            this.name = "Lenovo W530";

        if (country == null)
            this.country = "Azerbaijan";

        this.product = new Product(this.name, this.age, true, this.country, this.price);

        return this.product;
    }
}
