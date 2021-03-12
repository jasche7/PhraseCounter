package com.jasche.phrasecounter;

import java.util.LinkedList;
import java.util.List;

public class PhraseChainer {

    /**
     * Utility class should not be instantiated.
     */
    private PhraseChainer(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Take list of Strings as input, then use a nested for loop to
     * add every sublist in the list, concatenated, to a new list.
     * @param wordsList list of Strings
     * @return  list containing all sublists from wordsList, each
     *          concatenated into a single string
     */
    public static List<String> chainWords(List<String> wordsList){
        List<String> phraseList = new LinkedList<>();
        int listLength = wordsList.size();

        for(int listIndex = 0; listIndex < listLength; listIndex++){
            for(int nextIndices = listIndex + 1; nextIndices <= listLength; nextIndices++){
                List<String> wordsSublist = wordsList.subList(listIndex, nextIndices);
                String phrase = String.join(" ", wordsSublist);
                phraseList.add(phrase);
            }
        }
        return phraseList;
    }

}
