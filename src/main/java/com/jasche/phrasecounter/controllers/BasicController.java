package com.jasche.phrasecounter.controllers;

import com.jasche.phrasecounter.models.PhraseMaker;
import com.jasche.phrasecounter.services.FileOpener;
import com.jasche.phrasecounter.services.PhraseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Scanner;

/**
 * Rest controller for making PhraseCounter post requests.
 * 
 * @since v0.5.0
 */
@RestController
public class BasicController {

    /**
     * This mapping to /phrase for post request reads the text, minOccurrences, and
     * maxPhraseLength fields from request body.
     * 
     * @param phraseMaker data structure for HTTP request for creating phrase
     * @return HTTP response containing phrase counts
     */
    @PostMapping("/phrase")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> createProduct(@RequestBody PhraseMaker phraseMaker) {
        Scanner scanner = new Scanner(phraseMaker.getText());
        return ResponseEntity.ok(PhraseService.makePhrases(FileOpener.readWords(scanner), // creates list of strings
                                                                                          // from text field
                phraseMaker.getMinOccurrences(), phraseMaker.getMaxPhraseLength()));
    }
}
