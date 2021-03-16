package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenerTest {

    @Test
    void canReadInvalidFile(){
        assertThrows(FileNotFoundException.class, () -> FileOpener.readFile(""));
    }

    @Test
    void canReadWords(){
        Scanner scanner = new Scanner("I am testing that readWords can read.");
        List<String> testList = List.of("I", "am", "testing", "that", "readWords", "can", "read.");
        assertEquals(testList, FileOpener.readWords(scanner));
    }

    @Test
    void canReadEmpty(){
        Scanner scanner = new Scanner("");
        assertEquals(Collections.emptyList(), FileOpener.readWords(scanner));
    }
}
