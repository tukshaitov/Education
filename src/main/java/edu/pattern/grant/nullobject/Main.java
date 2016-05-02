package edu.pattern.grant.nullobject;

/**
 * Created by Eldar on 9/27/2015.
 */
public class Main {
    public static void main(String... args) {
        Instrument[] instruments = {new Violin(), new Guitar(), new NullInstrument(), new Guitar(), new Guitar(), new NullInstrument()};
        for (int i = 0; i < instruments.length; i++) {
            if (instruments[i].isNull()) {
                System.out.println("Null Position: " + i);
            }
        }
    }
}


