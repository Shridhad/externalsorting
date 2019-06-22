package me.shridhar;

import me.shridhar.util.ResourceLoader;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ExternalSorter sorter = new ExternalSorter();
        ResourceLoader loader = new ResourceLoader();

        File inputFile = loader.getResource("input.txt");
        File sortedFile = sorter.sort(inputFile);

        String path = System.getProperty("user.dir") + "/src/main/resources/sorted.txt";
        loader.writeResource(sortedFile, path);
    }
}
