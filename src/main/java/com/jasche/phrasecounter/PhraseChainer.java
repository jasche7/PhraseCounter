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
     * add all sublists of length less than phraseMaxLength in the list,
     * concatenated, to a new list. If phraseMaxLength is 0, there is no max.
     * @param wordsList list of Strings
     * @param phraseMaxLength   maximum length of sublist to be added to the output list
     * @return  list containing sublists from wordsList, each concatenated into one string
     */
    public static List<String> chainWords(List<String> wordsList, int phraseMaxLength){
        List<String> phraseList = new LinkedList<>();
        int listLength = wordsList.size();

        for(int listIndex = 0; listIndex < listLength; listIndex++){
            for(int nextIndices = listIndex + 1; nextIndices <= listLength; nextIndices++){
                if(phraseMaxLength != 0 && nextIndices - listIndex > phraseMaxLength) break;
                List<String> wordsSublist = wordsList.subList(listIndex, nextIndices);
                String phrase = String.join(" ", wordsSublist);
                phraseList.add(phrase);
            }
        }
        return phraseList;
    }

}
