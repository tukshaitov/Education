package edu.pattern.gof.strategy;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Strategy interface */
public interface Compressor {
    void compress();

    void compress(String str);

    void compress(CompressorContext context);
}
