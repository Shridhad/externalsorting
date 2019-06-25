package me.shridhar.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberWriter {
    private BufferedWriter writer;
    private File file;

    public NumberWriter() throws IOException {
        file = File.createTempFile("sorted", ".tmp.txt");
        file.deleteOnExit();
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void write(Integer number) throws IOException {
        writer.write(number.toString());
        writer.newLine();
    }

    public File getFile() {
        return file;
    }

    public void close() throws IOException {
        writer.close();
    }
}
