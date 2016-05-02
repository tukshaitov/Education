package edu.pattern.gof.visitor;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface Operation {
    void visit(File file);

    void visit(SymbolicLink link);

    void visit(Folder folder);
}
