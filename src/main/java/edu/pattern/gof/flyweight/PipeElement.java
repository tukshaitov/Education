package edu.pattern.gof.flyweight;


/**
 * Created by Eldar on 11/8/2015.
 */
public class PipeElement implements Comparable<PipeElement> {
    private double diameter;
    private int length;

    public PipeElement(double diameter, int length) {
        this.diameter = diameter;
        this.length = length;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int compareTo(PipeElement o) {
        if (o.diameter < this.length)
            return -1;
        else if (o.diameter == this.diameter) {
            if (o.length < this.length)
                return -1;
            else if (o.length == this.length)
                return 0;
            else return 1;
        } else
            return 1;
    }

    void draw(GraphicContext context, PipeElementOrient orient, Pipe.PipeElementContext pipeElementContext) {
        context.draw("{ PipeElement with diameter: " + diameter + " length: " + length + " for orient " + orient + " }");
    }
}
