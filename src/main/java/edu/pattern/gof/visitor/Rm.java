package edu.pattern.gof.visitor;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Rm implements Operation {
    @Override
    public void visit(File file) {
        System.out.println("File Name: " + file.getName() + " was removed.");
    }

    @Override
    public void visit(SymbolicLink link) {
        System.out.println("SymbolicLink Name: " + link.getName() + " was removed.");
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Folder Name: " + folder.getName() + " was removed.");
    }
}
