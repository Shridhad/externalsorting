package me.shridhar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ResourceLoaderTest {

    private ResourceLoader resourceLoader;

    @BeforeEach
    public void setUp() {
       resourceLoader = new ResourceLoader();
    }

    @Test
    public void testShouldLoadResourceFile() {
        File file = resourceLoader.getResource("numbers.txt");

        assertNotNull(file);
    }

    @Test
    public void testShouldThrowExceptionIfFileNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> resourceLoader.getResource("random.txt"));
    }
}