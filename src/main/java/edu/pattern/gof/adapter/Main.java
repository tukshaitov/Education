package edu.pattern.gof.adapter;

/**
 * Convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.
 * Also Known As Wrapper
 *
 */
public class Main {
    public static void main(String... args) {
        Main adapter = new Main();
        GoogleImageProcessor imageProcessor = new GoogleImageProcessor();
        AdobeImageProcessorAdapter imageProcessorAdapter = new AdobeImageProcessorAdapter(imageProcessor);
        imageProcessorAdapter.setX(10);
        imageProcessorAdapter.setY(20);
        if (adapter.processImage(imageProcessorAdapter, new Image()))
            System.out.println("Image was draw successful.");
        else
            System.out.println("Image was not draw.");


    }

    public boolean processImage(AdobeImageProcessor imageProcessor, Image img) {
        if (imageProcessor == null)
            return false;
        else
            return imageProcessor.draw(img);
    }
}

