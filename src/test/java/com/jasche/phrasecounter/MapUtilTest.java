package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapUtilTest {

    private static Map<String, Integer> testMap;

    @BeforeAll
    static void init(){
        testMap = new HashMap<>();
        testMap.put("fourth", 4);
        testMap.put("first", 1);
        testMap.put("fifth", 5);
        testMap.put("third", 3);
        testMap.put("second", 2);
    }

    @Test
    void canSortStringToIntegerMap() {
        Map<String, Integer> sortedMap = MapUtil.sortByValue(testMap);
        String sortedMapAsString = sortedMap.entrySet().toString();
        assertEquals("[first=1, second=2, third=3, fourth=4, fifth=5]", sortedMapAsString);
    }
}