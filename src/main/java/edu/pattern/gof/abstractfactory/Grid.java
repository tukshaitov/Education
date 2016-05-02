package edu.pattern.gof.abstractfactory;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface Grid extends Component {
    String getName();

    void setName(String name);

    void setSize(int columns, int rows);
}
