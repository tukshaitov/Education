package edu.pattern.gof.adapter;

/**
 * Created by Eldar on 11/8/2015.
 */
public class AdobeImageProcessorAdapter implements AdobeImageProcessor {

    GoogleImageProcessor googleImageProcessor;
    private int x;
    private int y;

    AdobeImageProcessorAdapter(GoogleImageProcessor googleImageProcessor) {
        this.googleImageProcessor = googleImageProcessor;
    }

    @Override
    public void setX(int x) {
        this.x = x;
        googleImageProcessor.setPosition(this.x, this.y);
    }

    @Override
    public void setY(int y) {
        this.y = y;
        googleImageProcessor.setPosition(this.x, this.y);
    }

    @Override
    public boolean draw(Image img) {
        googleImageProcessor.setImage(img);
        if (googleImageProcessor.draw() <= 0)
            return false;
        else return true;
    }
}
