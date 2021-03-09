package com.jasche.phrasecounter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * From Carter Page at https://stackoverflow.com/a/2581754
 */
public class MapUtil {

    private MapUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
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
}
