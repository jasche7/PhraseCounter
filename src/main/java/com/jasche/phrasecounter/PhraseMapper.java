package com.jasche.phrasecounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class that creates a map of strings to their number of occurrences.
 */
public class PhraseMapper {

    /**
     * Utility class should not be instantiated.
     */
    private PhraseMapper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * For each string in the list param phrases, add it to a map with
     * the value of 1 if the map doesn't already contain the string as a key.
     * If it does, increment the value associated with that key by 1.
     * At the end, check all entries in the map and delete any keys whose value
     * is less than minOccurrences.
     * @param phrases   list of strings whose strings will be mapped to their occurrence count
     * @param minOccurrences    retain only keys whose value is at least this number
     * @return  map of phrases to the integer number of times they occur
     */
    public static Map<String, Integer> mapPhraseCount(List<String> phrases, int minOccurrences) {
        Map<String, Integer> phraseMap = new HashMap<>();

        for (String p : phrases) {
            if (phraseMap.containsKey(p)) {
                phraseMap.put(p, phraseMap.get(p) + 1);
            }
            else {
                phraseMap.put(p, 1);
            }
        }

        phraseMap.entrySet().removeIf(entry -> entry.getValue() < minOccurrences);
        return phraseMap;
    }
}
