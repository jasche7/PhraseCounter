package com.jasche.phrasecounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenerTest {

    private FileOpener fileopener;

    @BeforeEach
    void init(){
        fileopener = new FileOpener("test.txt");
    }

    @Test
    void canGetFilename(){
        assertEquals("test.txt", fileopener.getFilename());
    }

    @Test
    void canSetFilename(){
        fileopener.setFilename("new.txt");
        assertEquals("new.txt", fileopener.getFilename());
    }

    @Test
    void canReadInvalidFile(){
        fileopener.setFilename("");
        assertThrows(FileNotFoundException.class, fileopener::readFile);
    }

    @Test
    void canReadWords(){
        Scanner scanner = new Scanner("I am testing that readWords can read.");
        List<String> testList = List.of("I", "am", "testing", "that", "readWords", "can", "read.");
        assertEquals(testList, fileopener.readWords(scanner));
    }

    @Test
    void canReadEmpty(){
        Scanner scanner = new Scanner("");
        assertEquals(Collections.emptyList(), fileopener.readWords(scanner));
    }
}