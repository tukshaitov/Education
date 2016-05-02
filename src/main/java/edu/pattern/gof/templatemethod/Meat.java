package edu.pattern.gof.templatemethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public abstract class Meat {

    /* A template method : */
    public final void dish() {
        if (buy() > 0) {
            prepare();
            fry();
        }
    }

    protected abstract int buy();

    protected abstract void prepare();

    protected abstract void fry();
}
