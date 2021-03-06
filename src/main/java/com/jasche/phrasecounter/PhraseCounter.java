package com.jasche.phrasecounter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

/**
 * Main class that reads a file and prints out every phrase from the file, in descending order
 * of number of occurrences. The output can be filtered.
 * @since v0.1.0
 */
public class PhraseCounter {

    /**
     * Helper method for printing error message on usage.
     */
    private static void incorrectArgs(){
        LOGGER.severe("Usage: <filepath> [# of minimum occurrences] [# of maximum phrase length]");
    }

    /**
     * Main function. Required first arg is filename, followed by two optional args for
     * minimum occurrences and maximum phrase length.
     * @param args  CLI arguments
     */
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 3) {
            incorrectArgs();
            return;
        }

        /*
         * Check if existing args[1] and/or args[2] are valid integers, so that
         * they can be set to minOccurrences and maxPhraseLength, respectively.
         */
        int minOccurrences = 0;
        int maxPhraseLength = 0;
        if (args.length > 1) {
            try {
                minOccurrences = Integer.parseInt(args[1]);
                if (args.length > 2) {
                    maxPhraseLength = Integer.parseInt(args[2]);
                }
            } catch (NumberFormatException e) {
                incorrectArgs();
                return;
            }
        }

        try {
            /*
             * Process file input in the following sequence:
             * file -> word list -> phrase list -> phrase map -> sorted phrase map (descending order) ->
             *   sorted phrase list -> print
             */
            List<String> wordsList = FileOpener.readFile(args[0]); // file -> word list
            List<String> phrasesList = PhraseChainer.chainWords(wordsList, maxPhraseLength); // word list -> phrase list
            Map<String, Integer> phraseMap = PhraseMapper.mapPhraseCount(phrasesList, minOccurrences); // phrase list -> phrase map
            Map<String, Integer> sortedPhraseMap = MapTransformer.sortMapDescendingValue(phraseMap); // phrase map -> sorted phrase map
            List<String> outputList = MapTransformer.convertMapToList(sortedPhraseMap); // sorted phrase map -> sorted phrase list
            ListPrinter.printList(outputList);
            /*
             * Log each intermediate step to fine level.
             */
            String logWords = "Words: " + wordsList.toString();
            String logPhrases = "Phrases: " + phrasesList.toString();
            String logMap = "Map: " + phraseMap.entrySet().toString();
            String logSortedMap = "Sorted Map: " + sortedPhraseMap.entrySet().toString();
            LOGGER.fine(logWords);
            LOGGER.fine(logPhrases);
            LOGGER.fine(logMap);
            LOGGER.fine(logSortedMap);
        } catch (FileNotFoundException e) {
            LOGGER.severe("File not found.");
        }
    }
}
