package edu.pattern.gof.flyweight;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Flight Weight Factory */
public class PipeElementFactory {
    private List<PipeElement> pipeCash = new ArrayList<>();
    private PipeElementPredicate predicate = new PipeElementPredicate();

    public PipeElement getPipeElement(double diameter, int length, boolean useCash) {
        if (useCash) {
            predicate.diameter = diameter;
            predicate.length = length;

            PipeElement pipeElement = CollectionUtils.find(pipeCash, predicate);
            if (pipeElement == null) {
                pipeElement = new PipeElement(diameter, length);
                Collections.sort(pipeCash);
            }
            return pipeElement;
        } else return new PipeElement(diameter, length);

    }

    static public class PipeElementPredicate implements Predicate<PipeElement> {
        private double diameter;
        private int length;

        @Override
        public boolean evaluate(PipeElement pipeElement) {
            if (pipeElement.getDiameter() == diameter && pipeElement.getLength() == length)
                return true;
            else
                return false;
        }
    }
}
