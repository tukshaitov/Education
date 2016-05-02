package edu.pattern.gof.strategy;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Strategy Context */
public class CompressorContext {

    private Compressor compressor;
    private String str;

    public CompressorContext() {
        this.compressor = new ZipCompressor(this);
    }

    public CompressorContext(Compressor compressor) {
        this.compressor = compressor;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public void compressWayOne() {
        if (this.compressor != null) {
            compressor.compress();
        }
    }

    public void compressWayTwo() {
        if (this.compressor != null) {
            compressor.compress(this);
        }
    }

    public void compressWayThree(String str) {
        if (this.compressor != null) {
            compressor.compress(str);
        }
    }
}
