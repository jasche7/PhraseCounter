package com.jasche.phrasecounter;

import java.util.logging.Logger;

public class MyLogger {

    /**
     * Utility class should not be instantiated.
     */
    private MyLogger(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create static Logger. Other classes can write to
     * log with the name LOGGER.
     */
    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
}
