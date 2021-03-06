package com.jasche.phrasecounter;

import java.io.FileNotFoundException;

import static com.jasche.phrasecounter.MyLogger.LOGGER;

public class PhraseCounter {

    public static void main(String[] args) {
        if(args.length != 1){
            LOGGER.severe("Must input file name");
            return;
        }

        FileOpener file = new FileOpener(args[0]);
        try {
            file.readFile();
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found.");
        }


    }
}
