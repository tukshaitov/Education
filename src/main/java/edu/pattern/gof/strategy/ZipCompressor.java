package edu.pattern.gof.strategy;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Strategy One */
public class ZipCompressor implements Compressor {

    private CompressorContext compressorContext;

    public ZipCompressor(CompressorContext compressorContext) {
        this.compressorContext = compressorContext;
    }

    public ZipCompressor() {

    }

    @Override
    public void compress() {
        if (this.compressorContext != null) {
            System.out.println("Zip compress text: " + this.compressorContext.getStr());
        }
    }

    @Override
    public void compress(String str) {
        System.out.println("Zip compress text: " + str);
    }

    @Override
    public void compress(CompressorContext context) {
        if (context != null) {
            System.out.println("Zip compress text: " + context.getStr());
        }
    }
}
