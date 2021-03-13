package com.jasche.phrasecounter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

public class PhraseCounter {

    public static void main(String[] args) {
        if(args.length > 3){
            LOGGER.severe("Usage: <filepath> [# of minimum occurrences] [# of maximum phrase length]");
            return;
        }

        int minOccurrences = 0;
        int maxPhraseLength = 0;
        if(args.length > 1 && Integer.TYPE.isInstance(args[1])){
            minOccurrences = Integer.parseInt(args[1]);
            if(args.length > 2 && Integer.TYPE.isInstance(args[2])){
                maxPhraseLength = Integer.parseInt(args[2]);
            }
        }

        try {
            /*
            Process file input in the following sequence:
            file -> word list -> phrase list -> phrase map -> sorted phrase map -> print
            */
            List<String> wordsList = FileOpener.readFile(args[0]);
            List<String> phrasesList = PhraseChainer.chainWords(wordsList, maxPhraseLength);
            Map<String, Integer> phraseMap = PhraseMapper.mapPhraseCount(phrasesList, minOccurrences);
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
