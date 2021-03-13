package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhraseMapperTest {

    @Test
    void canMapWords(){
        List<String> testList = List.of("a", "test", "test", "this", "is", "a", "test");

        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("test", 3);
        testMap.put("a", 2);
        testMap.put("this", 1);
        testMap.put("is", 1);

        assertEquals(testMap, PhraseMapper.mapPhraseCount(testList,0));
    }
}