package edu.pattern.bloch.builder;

/**
 * Created by Eldar on 11/8/2015.
 */
public class ImmutableProduct {
    private String name;
    private int age;
    private int price;
    private double size;

    private ImmutableProduct(String name, int age, int price, double size) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.size = size;
    }

    static public Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ImmutableProduct{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    public static class Builder {
        private String name = "Vehicle";
        private int age;
        private int price;
        private double size;

        private Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            if (age > 100 || age <= 0) throw new IllegalArgumentException();
            this.age = age;
            return this;
        }

        public Builder setPrice(int price) {
            if (price > 1000 || price <= 0) throw new IllegalArgumentException();
            this.price = price;
            return this;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public ImmutableProduct construct() throws ProductBuildException {
            if (age > 50 && price > 500)
                throw new ProductBuildException();

            return new ImmutableProduct(this.name, this.age, this.price, this.size);

        }
    }

}
