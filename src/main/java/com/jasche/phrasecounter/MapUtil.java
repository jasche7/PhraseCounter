package com.jasche.phrasecounter;

import java.util.*;

public class MapUtil {

    /**
     * Utility class should not be instantiated.
     */
    private MapUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * From Carter Page at https://stackoverflow.com/a/2581754
     *
     * Creates list of map entries from the map parameter.
     * Sorts the list by value in ascending order.
     * Creates a new linked hash map containing the list entries.
     * LinkedHashMap allows for consistent iteration.
     * @param map   map containing entries to be sorted
     * @param <K>   generic type for key
     * @param <V>   generic type for value
     * @return  linked hash map containing sorted entries from map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * Creates list iterator for the entrySet of the generic sortedMap param.
     * List iterator starts at the tail and prints out each entry until the head to standard output.
     * @param sortedMap map with generic typed key and value
     * @param <K>   generic type for sortedMap key
     * @param <V>   generic type for sortedMap value
     */
    public static <K, V extends Comparable<? super V>> void printSortedMap(Map<K, V> sortedMap){
        ListIterator<Map.Entry<K, V>> mapIterator =
                new ArrayList<>(sortedMap.entrySet()).listIterator(sortedMap.size());

        while (mapIterator.hasPrevious()) {
            Map.Entry<K, V> entry = mapIterator.previous();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
