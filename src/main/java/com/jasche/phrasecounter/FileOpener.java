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
     * Get and set the current value of filename.
     * Used for testing.
     * @return  path to the file to be opened
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @return
     */
    public List<String> readFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(filename));
        return readWords(scanner);
    }

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
