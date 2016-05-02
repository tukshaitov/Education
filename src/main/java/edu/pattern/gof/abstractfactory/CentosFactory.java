package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public class CentosFactory extends Main {
    @Override
    public Button createButton() {
        return new CentosButton();
    }

    @Override
    public Grid createGrid() {
        return new CentosGrid();
    }
}
