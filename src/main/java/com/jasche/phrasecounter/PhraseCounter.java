package com.jasche.phrasecounter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

public class PhraseCounter {

    /**
     * Helper method for printing error message on usage.
     */
    private static void incorrectArgs(){
        LOGGER.severe("Usage: <filepath> [# of minimum occurrences] [# of maximum phrase length]");
    }

    public static void main(String[] args) {
        if(args.length == 0 || args.length > 3){
            incorrectArgs();
            return;
        }
        int minOccurrences = 0;
        int maxPhraseLength = 0;
        /*
        Check if existing args[1] and/or args[2] are valid integers, so that
        they can be set to minOccurrences and maxPhraseLength, respectively.
         */
        if(args.length > 1){
            try{
                minOccurrences = Integer.parseInt(args[1]);
                if(args.length > 2){
                    maxPhraseLength = Integer.parseInt(args[2]);
                }
            } catch (NumberFormatException e){
                incorrectArgs();
                return;
            }
        }

        try {
            /*
            Process file input in the following sequence:
            file -> word list -> phrase list -> phrase map -> sorted phrase map (descending order) ->
                sorted phrase list -> print
            */
            List<String> wordsList = FileOpener.readFile(args[0]);
            List<String> phrasesList = PhraseChainer.chainWords(wordsList, maxPhraseLength);
            Map<String, Integer> phraseMap = PhraseMapper.mapPhraseCount(phrasesList, minOccurrences);
            Map<String, Integer> sortedPhraseMap = MapTransformer.sortMapDescendingValue(phraseMap);
            List<String> outputList = MapTransformer.convertMapToList(sortedPhraseMap);
            ListPrinter.printList(outputList);
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
