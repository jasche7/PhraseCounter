package com.jasche.phrasecounter.output;

import java.util.List;

/**
 * Utility class that prints out all strings from a list.
 * @since v0.3.0
 */
public class ListPrinter {

    /**
     * Utility class should not be instantiated.
     */
    private ListPrinter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Prints each string in stringList to standard output on a single line each.
     * @param stringList    list of strings to be printed
     */
    public static void printList(List<String> stringList) {
        for(String s : stringList){
            System.out.println(s);
        }
    }
}
