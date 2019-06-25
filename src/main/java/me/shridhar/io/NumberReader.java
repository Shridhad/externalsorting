package me.shridhar.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

public class NumberReader {
    private LineIterator iterator;
    private Integer cache;

    public NumberReader(File file) throws IOException {
        iterator = FileUtils.lineIterator(file);
    }

    public boolean hasNext() {
        if (cache != null) return true;
        cache = readNext();
        return cache != null;
    }

    public Integer peek() {
        return cache;
    }

    public Integer next() {
        Integer value = cache;
        cache = null;
        return value;
    }

    private Integer readNext() {
        return iterator.hasNext() ? Integer.parseInt(iterator.nextLine()) : null;
    }

    public void close() {
        iterator.close();
    }
}
