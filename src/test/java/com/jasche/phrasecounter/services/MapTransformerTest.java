package com.jasche.phrasecounter.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTransformerTest {

    @DisplayName("Given there is a map")
    @Nested
    class MapTest {
        private Map<String, Integer> testMap;
        private Map<String, Integer> testSortedMap;

        @BeforeEach
        void setUp() {
            testMap = new LinkedHashMap<>();
            testMap.put("fourth", 4);
            testMap.put("first", 1);
            testMap.put("fifth", 5);
            testMap.put("third", 3);
            testMap.put("second", 2);
            testSortedMap = new LinkedHashMap<>();
            testSortedMap.put("fifth", 5);
            testSortedMap.put("fourth", 4);
            testSortedMap.put("third", 3);
            testSortedMap.put("second", 2);
            testSortedMap.put("first", 1);
        }

        @DisplayName("When we want to sort the map")
        @Nested
        class SortMap {
            private Map<String, Integer> sortedMap;

            @BeforeEach
            void setUp(){
                sortedMap = MapTransformer.sortMapDescendingValue(testMap);
            }

            @DisplayName("Then the map will be sorted by value in descending order")
            @Test
            void testSortStringToIntegerMap() {
                String sortedMapAsString = sortedMap.entrySet().toString();
                assertEquals("[fifth=5, fourth=4, third=3, second=2, first=1]", sortedMapAsString);
            }
        }

        @DisplayName("When we want to convert the map to a list")
        @Nested
        class MapToList {

            private List<String> correctUnsortedList;
            private List<String> correctSortedList;
            private List<String> testUnsortedList;
            private List<String> testSortedList;

            @BeforeEach
            void setUp() {
                correctUnsortedList = new LinkedList<>(List.of(
                        "fourth=4",
                        "first=1",
                        "fifth=5",
                        "third=3",
                        "second=2"
                ));
                correctSortedList = new LinkedList<>(List.of(
                        "fifth=5",
                        "fourth=4",
                        "third=3",
                        "second=2",
                        "first=1"
                ));
                testUnsortedList = MapTransformer.convertMapToList(testMap);
                testSortedList = MapTransformer.convertMapToList(testSortedMap);
            }

            @DisplayName("Then an unsorted map will create an unsorted list")
            @Test
            void testCreateListFromUnsortedMap(){
                assertEquals(correctUnsortedList, testUnsortedList);
            }

            @DisplayName("Then a sorted map will create a sorted list")
            @Test
            void testCreateListFromSortedMap(){
                assertEquals(correctSortedList, testSortedList);
            }
        }
    }
}
