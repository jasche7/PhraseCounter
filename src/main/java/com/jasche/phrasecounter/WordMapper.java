package com.jasche.phrasecounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordMapper {

    private List<String> words;

    /**
     * Expects to receive a list of words from PhraseCounter,
     * which will later be used to create a map of strings to number of occurrences.
     * @param words list of strings containing the words to be counted
     */
    public WordMapper(List<String> words){
        setWords(words);
    }

    /**
     * Get the current value of words.
     * @return  list of strings containing the words to be counted
     */
    public List<String> getWords(){
        return words;
    }

    /**
     * Set the current value of words.
     * @param newWords list of strings containing the words to be counted
     */
    public void setWords(List<String> newWords) { words = newWords; }

    /**
     * For each string in the current value of words, add it to a map with
     * the value of 1 if the map doesn't already contain the string as a key.
     * If it does, increment the value associated with that key by 1.
     * @return  map of words to the integer number of times they occur
     */
    public Map<String, Integer> mapWordCount(){
        Map<String, Integer> newWordMap = new HashMap<>();
        for(String s : words){
            if(newWordMap.containsKey(s)){
                newWordMap.put(s, newWordMap.get(s) + 1);
            }
            else{
                newWordMap.put(s, 1);
            }
        }
        return newWordMap;
    }
}
