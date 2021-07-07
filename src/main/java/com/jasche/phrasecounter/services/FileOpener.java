package com.jasche.phrasecounter.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class that opens a filename and returns a list of all words from it.
 * @since v0.1.0
 */
public class  FileOpener {

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
        return readWords(scanner, false, false);
    }

    /**
     * Read word-by-word from scanner until no more words rema in.
     * Add each word to the linked list fileWords.
     * @param scanner   scanner that reads words
     * @param isCaseSensitive   if false, all words are set to lowercase
     * @param isIgnoringPunctuation if true, all leading and trailing punctuation is removed
     * @return  list of words from filename as a List of Strings
     */
    public static List<String> readWords(Scanner scanner, boolean isCaseSensitive, boolean isIgnoringPunctuation) {
        List<String> fileWords = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if(!isCaseSensitive) {
                word = word.toLowerCase();
            }
            if(isIgnoringPunctuation) {
                word = word.replaceFirst("^[^a-zA-Z0-9]+", ""); //removes all leading non-alphanumeric characters
                word = word.replaceAll("[^a-zA-Z0-9]+$", ""); // removes all trailing non-alphanumeric characters
            }
            fileWords.add(word);
        }
        scanner.close();
        return fileWords;
    }
}
