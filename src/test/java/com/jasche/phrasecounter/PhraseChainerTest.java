package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhraseChainerTest {

    private static List<String> testList;
    private static List<String> correctList;

    @BeforeAll
    static void init(){
        testList = new LinkedList<>(List.of(
                "I",
                "have",
                "taken",
                "the",
                "first",
                "napkin"));
        correctList = new LinkedList<>(List.of(
                "I",
                "I have",
                "I have taken",
                "I have taken the",
                "I have taken the first",
                "I have taken the first napkin",
                "have",
                "have taken",
                "have taken the",
                "have taken the first",
                "have taken the first napkin",
                "taken",
                "taken the",
                "taken the first",
                "taken the first napkin",
                "the",
                "the first",
                "the first napkin",
                "first",
                "first napkin",
                "napkin"));
        correctList.sort(Comparator.naturalOrder());
    }

    @Test
    void canBuildPhrase() {
        List<String> testPhrases = new LinkedList<>(PhraseChainer.chainWords(testList, 0));
        testPhrases.sort(Comparator.naturalOrder());
        assertEquals(correctList, testPhrases);
    }
}