package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhraseMapperTest {

    @DisplayName("Given there is a list of words")
    @Nested
    class MapTest {

        private List<String> testList;
        private Map<String, Integer> correctMap;

        Map<String, Integer> generateTestMap(int minOccurrences){
            return PhraseMapper.mapPhraseCount(testList, minOccurrences);
        }

        @BeforeEach
        void setUp(){
            testList = List.of("a", "test", "test", "this", "is", "a", "test");
            correctMap = new HashMap<>();
            correctMap.put("test", 3);
            correctMap.put("a", 2);
            correctMap.put("this", 1);
            correctMap.put("is", 1);
        }

        @DisplayName("When we want to map the words to their number of occurrences")
        @Nested
        class MapPhrases {

            @DisplayName("Then an extremely low minimum occurrence will include all words")
            @Test
            void canMapWordsMinLow(){
                assertEquals(correctMap, generateTestMap(Integer.MIN_VALUE));
            }

            @DisplayName("Then a minimum occurrence of 0 will include all words")
            @Test
            void canMapWords(){
                assertEquals(correctMap, generateTestMap(0));
            }

            @DisplayName("Then a minimum occurrence of 1 will include all words")
            @Test
            void canMapWordsMin1(){
                assertEquals(correctMap, generateTestMap(1));
            }

            @DisplayName("Then a minimum occurrence of 2 will include only words that occur at least twice")
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

            @DisplayName("Then an extremely high minimum occurrence will include no words")
            @Test
            void canMapWordsMinHigh(){
                assertEquals(Collections.emptyMap(), generateTestMap(Integer.MAX_VALUE));
            }
        }

    }

}
