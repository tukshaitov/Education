package edu.pattern.gof.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
* This type of design pattern comes under structural
* pattern  as  this  pattern  provides  ways  to  decrease  objects  count  thus  improving  application
* required objects structure.
 */
public class Main {
    public static void main(String... args) {
        GraphicContext graphicContext = new GraphicContext();
        PipeElementFactory factory = new PipeElementFactory();
        List<Pipe> pipeList = new ArrayList<>();
        pipeList.add(new StraightPipe(factory, 3, 30));
        pipeList.add(new StraightPipe(factory, 3, 60));
        pipeList.add(AnglePipe.getThinAnglePipe(factory));
        pipeList.add(new StraightPipe(factory, 3, 30));

        pipeList.get(0).setAttachment(PipeElementOrient.SINGLE, pipeList.get(1));
        pipeList.get(1).setAttachment(PipeElementOrient.SINGLE, pipeList.get(2));
        pipeList.get(2).setAttachment(PipeElementOrient.SINGLE, pipeList.get(3));
        pipeList.get(0).draw(graphicContext, true);

    }
}

