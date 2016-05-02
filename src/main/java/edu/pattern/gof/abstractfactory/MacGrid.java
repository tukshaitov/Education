package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public class MacGrid implements Grid {
    private String name;
    private int columns;
    private int rows;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSize(int columns, int rows) {
        if (columns <= 30)
            this.columns = columns;
        else
            this.columns = 30;

        this.rows = rows;
    }

    @Override
    public void draw() {
        System.out.println("Draw Mac Grid");
    }
}
