package com.jasche.phrasecounter.models;

import lombok.Data;

/**
 * Data structure for containing HTTP request for PhraseCounter.
 */
@Data
public class PhraseMaker {
    private String text;
    private int minOccurrences;
    private int maxPhraseLength;
}
