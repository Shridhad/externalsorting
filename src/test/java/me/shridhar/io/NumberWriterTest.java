package me.shridhar.io;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NumberWriterTest {

    private NumberWriter writer;

    @BeforeEach
    public void setUp() throws IOException {
        writer = new NumberWriter();
    }

    @AfterEach
    public void tearDown() throws IOException {
            writer.close();
    }

    @Test
    public void testShouldWriteNumbersToFile() throws IOException {
        List<Integer> integers = Arrays.asList(14, 121, 1, 185, 0);
        integers.forEach(this::writeNumber);

        writer.close();
        File file = writer.getFile();

        List<Integer> numbers = FileUtils.readLines(file).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertEquals(integers, numbers);
    }

    private void writeNumber(Integer num) {
        try {
            writer.write(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}