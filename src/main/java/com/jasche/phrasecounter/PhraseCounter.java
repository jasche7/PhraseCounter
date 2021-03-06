package com.jasche.phrasecounter;

import java.io.FileNotFoundException;

public class PhraseCounter {

    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Must input file name");
            return;
        }

        FileOpener file = new FileOpener(args[0]);
        try {
            file.readFile();
        } catch (FileNotFoundException e){
            System.err.println("File not found.");
        }

    }
}
