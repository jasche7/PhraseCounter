package com.jasche.phrasecounter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

public class PhraseCounter {

    public static void main(String[] args) {
        if(args.length != 1){
            LOGGER.severe("Must input file name");
            return;
        }

        FileOpener file = new FileOpener(args[0]);
        List<String> wordsList;
        try {
            wordsList = file.readFile();
            WordMapper map = new WordMapper(wordsList);
            Map<String, Integer> wordsMap = map.mapWordCount();
            Map<String, Integer> sortedWordsMap = MapUtil.sortByValue(wordsMap);

            String logWords = "Words: " + wordsList.toString();
            String logMap = "Map: " + wordsMap.entrySet().toString();
            String logSortedMap = "Sorted Map: " + sortedWordsMap.entrySet().toString();
            LOGGER.info(logWords);
            LOGGER.info(logMap);
            LOGGER.info(logSortedMap);
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found.");
        }
    }
}
