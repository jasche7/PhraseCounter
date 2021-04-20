package com.jasche.phrasecounter.models;

import lombok.Data;

/**
 * Data structure for containing HTTP request for PhraseCounter.
 *
 * text - text to read from
 * minOccurrences - minimum number of occurrences for a phrase to be included
 * maxPhraseLength - maximum number of words to be included in a phrase
 * isCaseSensitive - if false, ignore capitalization
 * isIgnoringPunctuation - if true, omit .,!?;: at the end of words
 */
@Data
public class PhraseMaker {
    private String text;
    private int minOccurrences;
    private int maxPhraseLength;
    private boolean caseSensitive;
    private boolean ignoringPunctuation;
}
