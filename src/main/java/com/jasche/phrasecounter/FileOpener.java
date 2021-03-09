package com.jasche.phrasecounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    private String filename;

    /**
     * Expects to receive a filename from PhraseCounter,
     * which will later be opened and read from word-by-word.
     * @param filename  path to the file to be opened
     */
    public FileOpener(String filename){
        setFilename(filename);
    }

    /**
     * Get the current value of filename.
     * Used for testing.
     * @return  path to the file to be opened
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Set the current value of filename.
     * @param filename path to the file to be opened
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Create scanner to read from filename.
     * Passes this scanner to readWords.
     * @return  list of all words from filename
     */
    public List<String> readFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(filename));
        return readWords(scanner);
    }

    /**
     * Read word-by-word from scanner until no more words remain.
     * Add each word to the linked list fileWords.
     * @param scanner   scanner, expected to read filename after being passed from readFile
     * @return          linked list of words from filename as a List of Strings
     */
    public List<String> readWords(Scanner scanner){
        List<String> fileWords = new LinkedList<>();
        while(scanner.hasNext()){
            String word = scanner.next();
            fileWords.add(word);
        }
        scanner.close();
        return fileWords;
    }
}
