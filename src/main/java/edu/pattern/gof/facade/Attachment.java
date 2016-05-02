package edu.pattern.gof.facade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Eldar on 11/9/2015.
 */
public class Attachment {
    private String file;
    private byte[] content;
    boolean loaded;

    public Attachment(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public byte[] getContent() {
        return content;
    }

    public Attachment load(){
        if (file == null) {
            loaded = false;
            return null;
        }
        Path path = Paths.get(file);
        try {
            byte[] data = Files.readAllBytes(path);
            loaded = true;
            return this;
        } catch (IOException e) {
            loaded = false;
            return null;
        }
    }

    public boolean isLoaded() {
        return loaded;
    }
}
