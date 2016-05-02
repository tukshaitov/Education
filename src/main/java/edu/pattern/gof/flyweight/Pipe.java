package edu.pattern.gof.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Eldar on 11/8/2015.
 */
abstract public class Pipe {

    protected Map<PipeElementOrient, PipeElementContext> contextMap = new HashMap<>();

    public void draw(GraphicContext context, boolean useChain) {
        for (PipeElementOrient orient : contextMap.keySet()) {
            PipeElementContext elementContext = contextMap.get(orient);

            if (elementContext.pipeElement != null)
                elementContext.pipeElement.draw(context, orient, elementContext);

            if (elementContext.attachment != null && useChain)
                elementContext.attachment.draw(context, useChain);
        }
    }

    public Set<PipeElementOrient> getElementOrientSet() {
        return contextMap.keySet();
    }

    public Pipe getAttachment(PipeElementOrient orient) {
        PipeElementContext context = contextMap.get(orient);
        if (context != null)
            return context.attachment;
        else
            return null;
    }

    public void setAttachment(PipeElementOrient orient, Pipe attachment) {
        PipeElementContext context = contextMap.get(orient);
        if (context != null)
            context.attachment = attachment;
    }

    protected static class PipeElementContext {
        private PipeElement pipeElement;
        private Pipe attachment;

        public PipeElementContext(PipeElement pipeElement, Pipe attachment) {
            this.pipeElement = pipeElement;
            this.attachment = attachment;
        }
    }
}
