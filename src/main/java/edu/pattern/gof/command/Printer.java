package edu.pattern.gof.command;

import java.util.Date;

/**
 * Created by Eldar on 11/8/2015.
 */ /*Receiver, Target Object*/
public class Printer {
    public void print(String str) {
        System.out.println("The string " + str + " is printed");
    }

    public void print(Page page) {
        System.out.println("The page " + page + " is printed");
    }

    public void turnOff() {
        System.out.println("The printer was turn of");
    }

    public boolean turnOn() {
        System.out.println("The printer was turn on");
        return true;
    }

    public boolean turnOn(Date date) {
        System.out.println("The printer was turn on");
        return true;
    }

    public void changeDye() {
        System.out.println("The dye was changed");
    }
}
