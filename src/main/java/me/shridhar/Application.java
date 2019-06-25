package me.shridhar;

import me.shridhar.util.ResourceLoader;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        ExternalSorter sorter = new ExternalSorter();
        ResourceLoader loader = new ResourceLoader();

        try {
            File inputFile = loader.getResource("input-big.txt");
            File sortedFile = sorter.sort(inputFile);

            String path = System.getProperty("user.dir") + "/src/main/resources/sorted-big.txt";
            loader.writeResource(sortedFile, path);
        } catch (IOException | IllegalArgumentException exe) {
            exe.printStackTrace();
        }
    }
}
