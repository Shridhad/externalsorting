package me.shridhar.io;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberReaderTest {

    private NumberReader reader;

    @BeforeEach
    public void setUp() throws IOException {
        File file = File.createTempFile("numbers", ".tmp.txt");
        FileUtils.writeLines(file, Arrays.asList(12, 133, 121, 41, 134));
        reader = new NumberReader(file);

        file.deleteOnExit();
    }

    @AfterEach
    public void tearDown() {
        reader.close();
    }

    @Test
    public void testHasNextShouldReturnTrue() {
        assertTrue(reader.hasNext());
    }

    @Test
    public void testPeekShouldReturnNumber() {
        assertTrue(reader.hasNext());

        assertEquals(12, reader.peek().intValue());
    }

    @Test
    public void testNextShouldReturnNumber() {
        assertTrue(reader.hasNext());

        Integer next = reader.next();
        assertNotNull(next);
        assertEquals(12, next.intValue());
    }


}