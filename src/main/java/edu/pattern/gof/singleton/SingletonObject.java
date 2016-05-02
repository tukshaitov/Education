package edu.pattern.gof.singleton;

/**
 * Created by Eldar on 11/8/2015.
 */
public class SingletonObject {

    private static final Object mutex = new Object();
    private static int _age;
    private static volatile SingletonObject object = null;
    private int age;

    private SingletonObject() {

    }

    public SingletonObject(int age) {
        this.age = age;
    }

    public static SingletonObject getSingleton(int age) {
        if (object == null) {
            synchronized (mutex) {
                if (object == null) {
                    object = new SingletonObject(age);
                }
            }
        }
        return object;
    }

    public static SingletonObject getAnotherSingleton(int age) {
        _age = age;
        return InnerSingleton.object;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingletonObject{" +
                "age=" + age +
                '}';
    }

    /* solution of Bill Pugh */
    private static class InnerSingleton {
        private final static SingletonObject object = new SingletonObject(_age);
    }
}
