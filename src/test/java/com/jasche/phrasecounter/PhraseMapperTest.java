package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhraseMapperTest {

    private static List<String> testList;
    private static Map<String, Integer> correctMap;

    Map<String, Integer> generateTestMap(int minOccurrences){
        return PhraseMapper.mapPhraseCount(testList, minOccurrences);
    }

    @BeforeAll
    static void init(){
        testList = List.of("a", "test", "test", "this", "is", "a", "test");
        correctMap = new HashMap<>();
        correctMap.put("test", 3);
        correctMap.put("a", 2);
        correctMap.put("this", 1);
        correctMap.put("is", 1);
    }

    @Test
    void canMapWords(){
        assertEquals(correctMap, generateTestMap(0));
    }

    @Test
    void canMapWordsMinLow(){
        assertEquals(correctMap, generateTestMap(Integer.MIN_VALUE));
    }

    @Test
    void canMapWordsMin2(){
        Map<String, Integer> testMap = generateTestMap(2);
        assertAll(
                () -> assertNull(testMap.get("this")),
                () -> assertNull(testMap.get("is")),
                () -> assertEquals(2, testMap.get("a")),
                () -> assertEquals(3, testMap.get("test"))
        );
    }

    @Test
    void canMapWordsMinHigh(){
        assertEquals(Collections.emptyMap(), generateTestMap(Integer.MAX_VALUE));
    }
}