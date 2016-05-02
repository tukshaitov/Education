package edu.pattern.gof.flyweight;

/**
 * Created by Eldar on 11/8/2015.
 */
public class StraightPipe extends Pipe {
    public StraightPipe(PipeElementFactory pipeElementFactory, int diameter, int length) {
        PipeElement pipeElement = pipeElementFactory.getPipeElement(diameter, length, false);
        PipeElementContext elementContext = new PipeElementContext(pipeElement, null);
        super.contextMap.put(PipeElementOrient.SINGLE, elementContext);
    }
}
