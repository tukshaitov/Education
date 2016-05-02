package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public class CentosGrid implements Grid {
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
        this.columns = 30;
        this.rows = rows;
    }

    @Override
    public void draw() {
        System.out.println("Draw Centos Grid");
    }
}
