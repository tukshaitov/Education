package edu.pattern.gof.builder;

/**
* The builder pattern is an object creation software design pattern. The intention is to abstract steps of construction of
* objects so that different implementations of these steps can construct different representations of objects. Often, the
* builder pattern is used to build products in accordance with the composite pattern.
*
* The intent of the Builder design pattern is to separate the construction of a complex object from its representation.
* By doing so, the same construction process can create different representations. [1]
*/
public class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public void construct(String name, String country, int age, int price) throws ProductBuildException {
        if (!builder.setAge(age))
            new ProductBuildException();

        builder.buildName(name).buildCountry(country);
        builder.setPrice(price);
    }

    public Product getProcuct() throws ProductBuildException {
        if (builder == null || builder.getProduct() == null)
            throw new ProductBuildException();
        else
            return builder.getProduct();
    }
}
