package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public class MacFactory extends Main {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Grid createGrid() {
        return new MacGrid();
    }
}
