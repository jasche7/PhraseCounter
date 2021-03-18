package com.jasche.phrasecounter;

import java.util.*;

public class MapTransformer {

    /**
     * Utility class should not be instantiated.
     */
    private MapTransformer(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * From Carter Page at https://stackoverflow.com/a/2581754
     *
     * Sorts map by descending order by using ArrayList as intermediate step.
     * Creates a new linked hash map containing the list entries, which can
     * be consistently iterated through.
     * @param map   map containing entries to be sorted
     * @param <K>   generic type for key
     * @param <V>   generic type for value
     * @return  linked hash map containing sorted entries from map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapDescendingValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * Creates list iterator for the entrySet of the generic sortedMap param.
     * It iterates through the map and creates a list of the map's entries as strings.
     * @param sortedMap map with generic typed key and value
     * @param <K>   generic type for sortedMap key
     * @param <V>   generic type for sortedMap value
     * @return  list containing sortedMap's entries as Strings, in reverse order
     */
    public static <K, V extends Comparable<? super V>> List<String> convertMapToList(Map<K, V> sortedMap){
        ListIterator<Map.Entry<K, V>> mapIterator =
                new ArrayList<>(sortedMap.entrySet()).listIterator();

        List<String> newList = new LinkedList<>();

        while (mapIterator.hasNext()) {
            Map.Entry<K, V> entry = mapIterator.next();
            newList.add(entry.toString());
        }

        return newList;
    }
}