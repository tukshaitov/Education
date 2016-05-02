package edu.pattern.telescoping;

import java.time.LocalDateTime;

/**
 * Created by eitukshaitov on 23.09.2015.
 */
public class Main {
    private int age;
    private double size;
    private String name;
    private LocalDateTime created;
    private int value;

    public Main(int age, double size, String name, LocalDateTime created, int value) {
        this.age = age;
        this.size = size;
        this.name = name;
        this.created = created;
        this.value = value;
    }

    public Main(int age, int value, double size) {
        this.age = age;
        this.value = value;
        this.size = size;
    }

    public Main(int value, LocalDateTime created, String name) {
        this.value = value;
        this.created = created;
        this.name = name;
    }

    public Main(int age) {
        this.age = age;
    }

    public Main(LocalDateTime created, String name) {
        this.created = created;
        this.name = name;
    }

    public Main(double size) {
        this.size = size;
    }

    public Main(LocalDateTime created) {
        this.created = created;
    }

    public Main(double size, String name) {
        this.size = size;
        this.name = name;
    }

    public static void main(String... args) {
        Main constructor = new Main(10, 12, "Lenovo W530", LocalDateTime.now(), 10);
        System.out.println(constructor.toString());
    }

    @Override
    public String toString() {
        return "Main{" +
                "age=" + age +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", value=" + value +
                '}';
    }
}
