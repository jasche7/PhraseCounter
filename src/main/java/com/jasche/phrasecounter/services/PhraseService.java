package com.jasche.phrasecounter.services;

import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.output.MyLogger.LOGGER;

/**
 * Helper class starts the pipeline for creating phrase counts. Originally called
 * by main in CLI PhraseCounter, but now called by rest API controller.
 */
public class PhraseService {

    /**
     * Utility class should not be instantiated.
     */
    private PhraseService() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Pipeline for creating phrase counts.
     * @param words list of strings
     * @param minOccurrences    minimum number of occurrences for a phrase to be included in results
     * @param maxPhraseLength   maximum length of phrase that can be included in results
     * @return  map of phrase counts sorted in descending order of occurrences
     */
    public static Map<String, Integer> makePhrases(List<String> words, int minOccurrences, int maxPhraseLength) {
        List<String> phrasesList = PhraseChainer.chainWords(words, maxPhraseLength); // word list -> phrase list
        Map<String, Integer> phraseMap = PhraseMapper.mapPhraseCount(phrasesList, minOccurrences); // phrase list -> phrase map

        /*
         * Log each intermediate step to fine level.
         */
        String logWords = "Words: " + words.toString();
        String logPhrases = "Phrases: " + phrasesList.toString();
        String logMap = "Map: " + phraseMap.entrySet().toString();

        LOGGER.fine(logWords);
        LOGGER.fine(logPhrases);
        LOGGER.fine(logMap);

        return MapTransformer.sortMapDescendingValue(phraseMap); // phrase map -> sorted phrase map
    }
}
