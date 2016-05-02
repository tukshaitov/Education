package edu.pattern.gof.visitor;

/**
 * Created by Eldar on 11/8/2015.
 */
public class MkDir implements Operation {
    @Override
    public void visit(File file) throws NotSupportedOperation {
        throw new NotSupportedOperation();
    }

    @Override
    public void visit(SymbolicLink link) throws NotSupportedOperation {
        throw new NotSupportedOperation();
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Folder Name: " + folder.getName() + " was created.");
    }
}
