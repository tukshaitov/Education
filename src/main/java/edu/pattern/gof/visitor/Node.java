package edu.pattern.gof.visitor;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface Node {
    void accept(Operation operation);
}
