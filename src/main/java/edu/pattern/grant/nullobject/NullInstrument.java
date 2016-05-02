package edu.pattern.grant.nullobject;

/**
 * Created by Eldar on 11/8/2015.
 */
public class NullInstrument implements Instrument {

    @Override
    public void play() {

    }

    @Override
    public boolean isNull() {
        return true;
    }
}
