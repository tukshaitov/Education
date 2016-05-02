package edu.pattern.gof.strategy;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Strategy Two */
public class LZMACompressor implements Compressor {

    private CompressorContext compressorContext;

    public LZMACompressor(CompressorContext compressorContext) {
        this.compressorContext = compressorContext;
    }

    public LZMACompressor() {

    }

    @Override
    public void compress() {
        if (this.compressorContext != null) {
            System.out.println("LZMA compress text: " + this.compressorContext.getStr());
        }
    }

    @Override
    public void compress(String str) {
        System.out.println("LZMA compress text: " + str);
    }

    @Override
    public void compress(CompressorContext context) {
        if (context != null) {
            System.out.println("LZMA compress text: " + context.getStr());
        }
    }
}
