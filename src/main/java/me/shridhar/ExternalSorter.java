package me.shridhar;

import me.shridhar.io.NumberReader;
import me.shridhar.io.NumberWriter;
import me.shridhar.io.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExternalSorter {
    private final int MAX_NUMBERS_PER_FILE = 100;
    private final Writer writer;

    ExternalSorter() {
        writer = new Writer();
    }

    File sort(File inputFile) throws IOException {
        List<File> tempFiles = splitAndSort(inputFile);

        return merge(tempFiles);
    }

    /**
     *  Read and sort `MAX_NUMBERS_PER_FILE` numbers in memory and save them to tempFile.
     *
     * @param inputFile     input file with numbers to sort
     * @return tempFiles    N tempFiles each contains `MAX_NUMBERS_PER_FILE` in sorted order
     * @throws IOException
     */
    private List<File> splitAndSort(File inputFile) throws IOException {
        List<File> tempFiles = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = "";
            while (line != null) {
                int counter = 0;
                numbers.clear();
                while (counter <= MAX_NUMBERS_PER_FILE &&
                        (line = reader.readLine()) != null) {
                    numbers.add(Integer.parseInt(line));
                    counter++;
                }
                if (!numbers.isEmpty()) {
                    tempFiles.add(sortAndSave(numbers));
                }
            }
        } catch (EOFException eof) {
            if (!numbers.isEmpty()) {
                tempFiles.add(sortAndSave(numbers));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tempFiles;
    }

    private File sortAndSave(List<Integer> numbers) throws IOException {
        Collections.sort(numbers);
        return writer.writeNumbers(numbers);
    }

    /**
     *  Merges all `files` into one single file using merge sort logic
     *
     * @param files     tempFiles to merge into one file
     * @return file     result of merge
     */
    private File merge(List<File> files) {
        while (files.size() > 1) {
            File file1 = files.remove(0);
            File file2 = files.remove(0);
            File newFile = mergeFiles(file1, file2);
            files.add(newFile);
        }
        return files.get(0);
    }

    /**
     * Merges `file1` and `file2`  into one single file in sorted order
     *
     * @param file1     First file
     * @param file2     Second file
     * @return file     Returns merged file
     */
    private File mergeFiles(File file1, File file2) {
        try {
            NumberReader reader1 = new NumberReader(file1);
            NumberReader reader2 = new NumberReader(file2);
            NumberWriter writer = new NumberWriter();

            while (reader1.hasNext() && reader2.hasNext()) {
                if (reader1.peek() <= reader2.peek()) {
                    Integer number = reader1.next();
                    writer.write(number);
                } else {
                    Integer number = reader2.next();
                    writer.write(number);
                }
            }

            while (reader1.hasNext()) {
                writer.write(reader1.next());
            }
            while (reader2.hasNext()) {
                writer.write(reader2.next());
            }
            writer.close();
            reader1.close();
            reader2.close();
            return writer.getFile();
        } catch (IOException exe) {
            exe.printStackTrace();
        }

        return null;
    }
}
