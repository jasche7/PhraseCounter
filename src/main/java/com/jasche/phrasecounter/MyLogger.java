package com.jasche.phrasecounter;

import java.util.logging.Logger;

public class MyLogger {

    private MyLogger(){
        throw new IllegalStateException("Utility class");
    }

    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
}
