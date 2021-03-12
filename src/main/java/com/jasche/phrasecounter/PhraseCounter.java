package com.jasche.phrasecounter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

public class PhraseCounter {

    public static void main(String[] args) {
        if(args.length != 1){
            LOGGER.severe("Enter filepath as argument");
            return;
        }

        FileOpener file = new FileOpener(args[0]);
        List<String> wordsList;
        try {
            /*
            Process file input in the following sequence:
            file -> word list -> phrase list -> phrase map -> sorted phrase map -> print
            */
            wordsList = file.readFile();
            List<String> phrasesList = PhraseChainer.chainWords(wordsList);
            PhraseMapper map = new PhraseMapper(phrasesList);
            Map<String, Integer> phraseMap = map.mapPhraseCount();
            Map<String, Integer> sortedPhraseMap = MapUtil.sortByValue(phraseMap);
            MapUtil.printSortedMap(sortedPhraseMap);

            /*
            Log each intermediate step to fine level.
             */
            String logWords = "Words: " + wordsList.toString();
            String logPhrases = "Phrases: " + phrasesList.toString();
            String logMap = "Map: " + phraseMap.entrySet().toString();
            String logSortedMap = "Sorted Map: " + sortedPhraseMap.entrySet().toString();
            LOGGER.fine(logWords);
            LOGGER.fine(logPhrases);
            LOGGER.fine(logMap);
            LOGGER.fine(logSortedMap);
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found.");
        }
    }
}
