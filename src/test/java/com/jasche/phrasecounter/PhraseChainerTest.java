package com.jasche.phrasecounter;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhraseChainerTest {

    @DisplayName("Given there is a list of words")
    @Nested
    class ListTest{

        private List<String> testList;
        private List<String> correctList;
        private List<String> correctListForLength1;
        private List<String> correctListForLength2;

        List<String> generateTestPhrases(int maxPhraseLength){
            return new LinkedList<>(PhraseChainer.chainWords(testList, maxPhraseLength));
        }

        @BeforeEach
        void setUp(){
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
        }

        @DisplayName("When we want to create phrases from those words")
        @Nested
        class CreatePhrases {

            @DisplayName("Then a max phrase length of 0 will create all normal phrases")
            @Test
            void canBuildPhrase(){
                assertEquals(correctList, generateTestPhrases(0));
            }

            @DisplayName("Then a negative max phrase length will create no phrases")
            @Test
            void canSetMaxPhraseLengthNegative(){
                assertEquals(Collections.emptyList(), generateTestPhrases(Integer.MIN_VALUE));
            }

            @DisplayName("Then a max phrase length of 1 will be identical to the original list")
            @Test
            void canSetMaxPhraseLength1(){
                assertEquals(testList, generateTestPhrases(1));
            }

            @DisplayName("Then a max phrase length of 'n' will create phrases of length up to 'n'")
            @Test
            void canSetMaxPhraseLength2(){
                assertEquals(correctListForLength2, generateTestPhrases(2));
            }

            @DisplayName("Then a very high max phrase length will create all normal phrases")
            @Test
            void canSetMaxPhraseLengthHigh(){
                assertEquals(correctList, generateTestPhrases(Integer.MAX_VALUE));
            }
        }

    }

}
