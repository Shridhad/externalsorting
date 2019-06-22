package me.shridhar;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExternalSorter {

    public File sort(File inputFile) throws IOException {
        List<Integer> numbers = readFile(inputFile);
        Collections.sort(numbers);
        return write(numbers);
    }

    private List<Integer> readFile(File inputFile) {
        Path path = Paths.get(inputFile.getAbsolutePath());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private File write(List<Integer> numbers) throws IOException {
        File tempFile = File.createTempFile("sorted", ".txt.tmp");
        FileUtils.writeLines(tempFile, numbers);
        return tempFile;
    }
}
