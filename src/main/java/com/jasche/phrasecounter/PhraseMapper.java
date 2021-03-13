package com.jasche.phrasecounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhraseMapper {

    private List<String> phrases;

    /**
     * Expects to receive a list of phrases from PhraseCounter,
     * which will later be used to create a map of strings to number of occurrences.
     * @param phrases list of strings containing the phrases to be counted
     */
    public PhraseMapper(List<String> phrases){
        setPhrases(phrases);
    }

    /**
     * Get the current value of phrases.
     * @return  list of strings containing the phrases to be counted
     */
    public List<String> getPhrases(){
        return phrases;
    }

    /**
     * Set the current value of phrases.
     * @param newPhrases list of strings containing the phrases to be counted
     */
    public void setPhrases(List<String> newPhrases) { phrases = newPhrases; }

    /**
     * For each string in the current value of phrases, add it to a map with
     * the value of 1 if the map doesn't already contain the string as a key.
     * If it does, increment the value associated with that key by 1.
     * At the end, check all entries in the map and delete any keys whose value
     * is less than minOccurrences.
     * @param minOccurrences    retain only keys whose value is at least this number
     * @return  map of phrases to the integer number of times they occur
     */
    public Map<String, Integer> mapPhraseCount(int minOccurrences){
        Map<String, Integer> newPhraseMap = new HashMap<>();
        for(String p : phrases){
            if(newPhraseMap.containsKey(p)){
                newPhraseMap.put(p, newPhraseMap.get(p) + 1);
            }
            else{
                newPhraseMap.put(p, 1);
            }
        }
        for(Map.Entry<String, Integer> e: newPhraseMap.entrySet()){
            if(e.getValue() < minOccurrences){
                newPhraseMap.remove(e.getKey());
            }
        }
        return newPhraseMap;
    }
}
