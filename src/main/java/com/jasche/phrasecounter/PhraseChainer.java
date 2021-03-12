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
     *
     * @param wordsList
     * @return
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
