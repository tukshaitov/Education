package edu.pattern.gof.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Compose objects into tree structures to represent part-whole hierarchies.
 * Composite lets clients treat individual objects and compositions of objects uniformly.
 */

public class Main {
    /*public static void main(String... args) {
        DocumentNode documentNode = new RootNode();
        documentNode.add(new Element(25)).add(new Element(36));

        System.out.println("Total Cost: " + documentNode.getTotalCost());
    }*/

    public static void main(String... args) {
        DocumentNode documentNode = new DocumentNode();
        documentNode.add(new Element(25)).add(new Element(36));
        List<CommonNode> list = new ArrayList<>();
        list.add(documentNode);

        System.out.println("Total Cost: " + documentNode.getCost());
    }
}


/*abstract public class DocumentNode {

    private Set<DocumentNode> nodeSet = new HashSet<>();
    private DocumentNode parentNode;

    public DocumentNode add(DocumentNode node) {
        nodeSet.add(node);
        node.parentNode = this;
        return this;
    }

    public boolean remove() {
        if (this.parentNode != null) {
            this.parentNode.nodeSet.remove(this);
            this.parentNode = null;
            return true;
        } else
            return false;
    }

    public boolean remove(DocumentNode documentNode) {
        if (nodeSet.remove(documentNode)) {
            documentNode.parentNode = null;
            return true;
        }
        return false;

    }

    public int getTotalCost() {
        int sum = getCost();
        for (DocumentNode documentNode : nodeSet) {
            sum += documentNode.getTotalCost();
        }
        return sum;
    }

    public abstract int getCost();

    public abstract String getText();
}


public class RootNode extends DocumentNode {

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getText() {
        return "RootNode";
    }
}


public class Element extends DocumentNode {

    private int cost;

    public Element(int cost) {
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getText() {
        return "Element with cost";
    }
}*/