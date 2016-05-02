package edu.pattern.gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an operation to be performed on the elements of an object structure.
 * Visitor lets you define a new operation without changing the classes of the elements on which it operates.
 */
public class Main {
    public static void main(String... args) {
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new File("document.xls"));
        nodeList.add(new Folder("C:\\Documents"));
        nodeList.add(new SymbolicLink("docs"));
        Operation rm = new Rm();
        Operation mkdir = new MkDir();

        for (Node node : nodeList) {
            node.accept(rm);
        }

        for (Node node : nodeList) {
            try {
                node.accept(mkdir);
            } catch (RuntimeException e) {
                System.out.println("Node Type " + node.getClass() + " not supported by this operation.");
            }
        }
    }
}

