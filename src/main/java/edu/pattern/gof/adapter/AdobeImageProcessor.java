package edu.pattern.gof.adapter;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface AdobeImageProcessor {
    void setX(int x);

    void setY(int y);

    boolean draw(Image img);
}
