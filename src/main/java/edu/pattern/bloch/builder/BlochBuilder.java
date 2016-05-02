package edu.pattern.bloch.builder;

public class BlochBuilder {
    public static void main(String... args) {
        ImmutableProduct.Builder builder = ImmutableProduct.newBuilder();
        builder.setAge(60).setPrice(60).setName("HP Pavilion MA50").setSize(15);
        try {
            ImmutableProduct product = builder.construct();
            System.out.println(product);

        } catch (ProductBuildException e) {
            e.printStackTrace();
        }
    }
}

