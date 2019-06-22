package me.shridhar.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ResourceLoader {

    public File getResource(String path) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(path);
        if (resource != null) {
            return new File(resource.getFile());
        }

        throw new IllegalArgumentException("File not found");
    }

    public boolean writeResource(File input, String path) throws IOException {
        File file = new File(path);
        FileUtils.copyFile(input, file);
        return true;
    }
}
