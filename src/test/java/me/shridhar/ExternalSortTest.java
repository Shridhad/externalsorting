package me.shridhar;

import me.shridhar.util.ResourceLoader;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExternalSortTest {

    private ExternalSorter sorter;
    private ResourceLoader resourceLoader;

    @BeforeEach
    public void setUp() {
        sorter = new ExternalSorter();
        resourceLoader = new ResourceLoader();
    }

    @Test
    public void testShouldSortInputFile() throws IOException {
        File inputFile = resourceLoader.getResource("numbers.txt");
        File outputFile = resourceLoader.getResource("sorted.txt");

        File sorted = sorter.sort(inputFile);
        assertTrue(FileUtils.contentEquals(outputFile, sorted), "Failed to sort the file content.");
    }
}