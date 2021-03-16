package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapUtilTest {

    private static Map<String, Integer> testMap;
    private static Map<String, Integer> testSortedMap;
    private static List<String> testList;

    @BeforeAll
    static void init(){
        testMap = new HashMap<>();
        testMap.put("fourth", 4);
        testMap.put("first", 1);
        testMap.put("fifth", 5);
        testMap.put("third", 3);
        testMap.put("second", 2);
        testSortedMap = new LinkedHashMap<>();
        testSortedMap.put("first", 1);
        testSortedMap.put("second", 2);
        testSortedMap.put("third", 3);
        testSortedMap.put("fourth", 4);
        testSortedMap.put("fifth", 5);
        testList = new LinkedList<>(List.of(
                "first=1",
                "second=2",
                "third=3",
                "fourth=4",
                "fifth=5"));
    }

    @Test
    void canSortStringToIntegerMap(){
        Map<String, Integer> sortedMap = MapUtil.sortByValue(testMap);
        String sortedMapAsString = sortedMap.entrySet().toString();
        assertEquals("[fifth=5, fourth=4, third=3, second=2, first=1]", sortedMapAsString);
    }

    @Test
    void canCreateListFromMap(){
        assertEquals(testList, MapUtil.convertMapToList(testSortedMap));
    }
}
