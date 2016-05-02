package edu.pattern.gof.flyweight;

/**
 * Created by Eldar on 11/8/2015.
 */
public class AnglePipe extends Pipe {
    public AnglePipe(PipeElementFactory pipeElementFactory, int diameter, int length) {
        PipeElement pipeElement = pipeElementFactory.getPipeElement(diameter, length, true);
        PipeElementContext elementContext = new PipeElementContext(pipeElement, null);
        super.contextMap.put(PipeElementOrient.ANGLE, elementContext);
    }

    public static AnglePipe getThinAnglePipe(PipeElementFactory pipeElementFactory) {
        return new AnglePipe(pipeElementFactory, 3, 20);
    }
}
