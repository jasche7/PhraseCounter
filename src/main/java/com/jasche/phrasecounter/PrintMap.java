package com.jasche.phrasecounter;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

public class PrintMap {

    private PrintMap(){
        throw new IllegalStateException("Utility class");
    }

    public static void printSortedMap(Map<String, Integer> sortedMap){
        ListIterator<Map.Entry<String, Integer>> mapIterator =
                new ArrayList<>(sortedMap.entrySet()).listIterator(sortedMap.size());

        while (mapIterator.hasPrevious()) {
            Map.Entry<String, Integer> entry = mapIterator.previous();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
