package edu.pattern.gof.builder;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Product {
    private String name;
    private int age;
    private boolean isAcceptable;
    private String country;
    private int price;

    public Product() {
    }

    public Product(String name, int age, boolean isAcceptable, String country, int price) {
        this.name = name;
        this.age = age;
        this.isAcceptable = isAcceptable;
        this.country = country;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAcceptable() {
        return isAcceptable;
    }

    public void setAcceptable(boolean isAcceptable) {
        this.isAcceptable = isAcceptable;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAcceptable=" + isAcceptable +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
