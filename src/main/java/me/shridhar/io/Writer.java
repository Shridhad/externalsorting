package me.shridhar.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Writer {

    public File writeNumbers(List<Integer> numbers) throws IOException {
        File tempFile = File.createTempFile("sorted", ".tmp.txt");
        tempFile.deleteOnExit();
        FileUtils.writeLines(tempFile, numbers);
        return tempFile;
    }
}
