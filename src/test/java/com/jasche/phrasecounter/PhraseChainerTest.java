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
            List<String> testPhrases = new LinkedList<>(PhraseChainer.chainWords(testList, maxPhraseLength));
            testPhrases.sort(Comparator.naturalOrder());
            return testPhrases;
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

        @DisplayName("When we want to create phrases from those words")
        @Nested
        class CreatePhrases {

            @DisplayName("Then a max phrase length of 0 will create all normal phrases")
            @Test
            void canBuildPhrase(){
                List<String> testPhrases = generateTestPhrases(0);
                assertEquals(correctList, testPhrases);
            }

            @DisplayName("Then a negative max phrase length will create no phrases")
            @Test
            void canSetMaxPhraseLengthNegative(){
                List<String> testPhrases = generateTestPhrases((Integer.MIN_VALUE));
                assertEquals(Collections.emptyList(), testPhrases);
            }

            @DisplayName("Then a max phrase length of 1 will be identical to the original list")
            @Test
            void canSetMaxPhraseLength1(){
                List<String> testPhrases = generateTestPhrases(1);
                assertEquals(correctListForLength1, testPhrases);
            }

            @DisplayName("Then a max phrase length of 'n' will create phrases of length up to 'n'")
            @Test
            void canSetMaxPhraseLength2(){
                List<String> testPhrases = generateTestPhrases(2);
                assertEquals(correctListForLength2, testPhrases);
            }

            @DisplayName("Then a very high max phrase length will create all normal phrases")
            @Test
            void canSetMaxPhraseLengthHigh(){
                List<String> testPhrases = generateTestPhrases(Integer.MAX_VALUE);
                assertEquals(correctList, testPhrases);
            }
        }

    }

}
