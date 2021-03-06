package com.jasche.phrasecounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class that opens a filename and returns a list of all words from it.
 * @since v0.1.0
 */
public class FileOpener {

    /**
     * Utility class should not be instantiated.
     */
    private FileOpener() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create scanner to read from filename.
     * Passes this scanner to readWords.
     * @param filename filepath for file to open
     * @return  list of all words from filename
     * @throws FileNotFoundException    if filename is invalid
     */
    public static List<String> readFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        return readWords(scanner);
    }

    /**
     * Read word-by-word from scanner until no more words remain.
     * Add each word to the linked list fileWords.
     * @param scanner   scanner, expected to read filename after being passed from readFile
     * @return          linked list of words from filename as a List of Strings
     */
    public static List<String> readWords(Scanner scanner) {
        List<String> fileWords = new LinkedList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            fileWords.add(word);
        }
        scanner.close();
        return fileWords;
    }
}
