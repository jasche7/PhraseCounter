package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhraseChainerTest {

    private static List<String> testList;
    private static List<String> correctList;
    private static List<String> correctListForLength1;
    private static List<String> correctListForLength2;

    List<String> generateTestPhrases(int maxPhraseLength){
        List<String> testPhrases = new LinkedList<>(PhraseChainer.chainWords(testList, maxPhraseLength));
        testPhrases.sort(Comparator.naturalOrder());
        return testPhrases;
    }

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
        correctListForLength1 = new LinkedList<>(testList);
        correctListForLength2 = new LinkedList<>(List.of(
                "I",
                "I have",
                "have",
                "have taken",
                "taken",
                "taken the",
                "the",
                "the first",
                "first",
                "first napkin",
                "napkin"
        ));

        correctList.sort(Comparator.naturalOrder());
        correctListForLength1.sort(Comparator.naturalOrder());
        correctListForLength2.sort(Comparator.naturalOrder());
    }

    @Test
    void canBuildPhrase(){
        List<String> testPhrases = generateTestPhrases(0);
        assertEquals(correctList, testPhrases);
    }

    @Test
    void canSetMaxPhraseLength1(){
        List<String> testPhrases = generateTestPhrases(1);
        assertEquals(correctListForLength1, testPhrases);
    }

    @Test
    void canSetMaxPhraseLength2(){
        List<String> testPhrases = generateTestPhrases(2);
        assertEquals(correctListForLength2, testPhrases);
    }

    @Test
    void canSetMaxPhraseLengthHigh(){
        List<String> testPhrases = generateTestPhrases(100);
        assertEquals(correctList, testPhrases);
    }
}