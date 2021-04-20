package com.jasche.phrasecounter.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileOpenerTest {

    @DisplayName("Given that there is a file to read")
    @Nested
    class ReadFileTest {
        private String filename;

        @DisplayName("When the file is invalid")
        @Nested
        class InvalidFile {

            @BeforeEach
            void setUp() {
                filename = "";
            }

            @DisplayName("Then a file not found error is given")
            @Test
            void exceptionOnReadInvalidFile() {
                assertThrows(FileNotFoundException.class, () -> FileOpener.readFile(filename));
            }
        }
    }

    @DisplayName("Given that there are words to read")
    @Nested
    class ReadWordsTest {
        private Scanner scanner;
        private List<String> testList;
        private List<String> testListNCS;
        private List<String> testListNP;
        private List<String> testListBoth;

        @DisplayName("When there are valid words")
        @Nested
        class ValidWords {

            @BeforeEach
            void setUp() {
                scanner = new Scanner("I am 'testing' that readWords can read...");
                testList = List.of("I", "am", "'testing'", "that", "readWords", "can", "read...");
                testListNCS = List.of("i", "am", "'testing'", "that", "readwords", "can", "read...");
                testListNP = List.of("I", "am", "testing", "that", "readWords", "can", "read");
                testListBoth = List.of("i", "am", "testing", "that", "readwords", "can", "read");
            }

            @DisplayName("Then a list can be created with those words")
            @Test
            void canReadWords() {
                assertEquals(testList, FileOpener.readWords(scanner, true, false));
            }

            @DisplayName("Then we can read them without case sensitivity")
            @Test
            void canReadNonCaseSensitive() {
                assertEquals(testListNCS, FileOpener.readWords(scanner, false, false));
            }

            @DisplayName("Then we can read them while omitting punctuation at the start and end")
            @Test
            void canReadNoPunctuation() {
                assertEquals(testListNP, FileOpener.readWords(scanner, true, true));
            }

            @DisplayName("Then we can read them with both of the previous two settings")
            @Test
            void canReadBoth() {
                assertEquals(testListBoth, FileOpener.readWords(scanner, false, true));
            }
        }

        @DisplayName("When the words are empty")
        @Nested
        class EmptyWords {

            @BeforeEach
            void setUp() {
                scanner = new Scanner("");
                testList = Collections.emptyList();
            }

            @DisplayName("Then an empty list is created")
            @Test
            void canReadEmpty() {
                assertEquals(testList, FileOpener.readWords(scanner, false, false));
            }
        }
    }
}
