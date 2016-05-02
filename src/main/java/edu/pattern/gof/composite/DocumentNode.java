package edu.pattern.gof.composite;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eldar on 11/8/2015.
 */
public class DocumentNode implements CommonNode {

    private Set<CommonNode> nodeSet = new HashSet<CommonNode>();

    public DocumentNode add(CommonNode node) {
        nodeSet.add(node);
        return this;
    }

    public boolean remove(CommonNode commonNode) {
        if (nodeSet.remove(commonNode))
            return true;
        return false;

    }

    @Override
    public int getCost() {
        int sum = 0;
        for (CommonNode commonNode : nodeSet) {
            sum += commonNode.getCost();
        }
        return sum;
    }

    @Override
    public String getText() {
        return "Composite Node";
    }
}
