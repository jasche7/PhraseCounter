package com.jasche.phrasecounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that reads a file and prints out every phrase from the file, in descending order
 * of number of occurrences. The output can be filtered.
 * @since v0.1.0
 */
@SpringBootApplication
public class PhraseCounter {

    /**
     * Main function for starting SpringApplication.
     * @param args  CLI arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PhraseCounter.class, args);
    }
}
