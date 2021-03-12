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
            //file -> word list -> word map -> sorted word map -> print
            wordsList = file.readFile();
            PhraseMapper map = new PhraseMapper(wordsList);
            Map<String, Integer> wordsMap = map.mapPhraseCount();
            Map<String, Integer> sortedWordsMap = MapUtil.sortByValue(wordsMap);
            MapUtil.printSortedMap(sortedWordsMap);

            String logWords = "Words: " + wordsList.toString();
            String logMap = "Map: " + wordsMap.entrySet().toString();
            String logSortedMap = "Sorted Map: " + sortedWordsMap.entrySet().toString();
            LOGGER.fine(logWords);
            LOGGER.fine(logMap);
            LOGGER.fine(logSortedMap);
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found.");
        }
    }
}
