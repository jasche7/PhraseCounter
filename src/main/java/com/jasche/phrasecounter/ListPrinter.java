package com.jasche.phrasecounter;

import java.util.List;

public class ListPrinter {

    /**
     * Utility class should not be instantiated.
     */
    private ListPrinter(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Prints each string in stringList to standard output on a single line each.
     * @param stringList    list of strings to be printed
     */
    public static void printList(List<String> stringList){
        for(String s : stringList){
            System.out.println(s);
        }
    }
}
