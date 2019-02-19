package com.codecool.textexpert.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;

import com.codecool.textexpert.dao.FileContent;

class StatisticalAnalysisTest {

    private StatisticalAnalysis charAnalysis;
    private StatisticalAnalysis wordAnalysis;
    private PrintStream originalOutput;
    private ByteArrayOutputStream currentOutput;

    @BeforeEach
    void init() {
        charAnalysis = new StatisticalAnalysis(new FileContent("src/test/resources/text_files/test.txt").charIterator());
        wordAnalysis = new StatisticalAnalysis(new FileContent("src/test/resources/text_files/test.txt").wordIterator());
    }

    @Test
    void countOfSingleElement() {
        assertEquals(82, charAnalysis.countOf("a"));
    }

    @Test
    void countOfMultipleElements() {
        assertEquals(119, charAnalysis.countOf("a", "b", "c"));
    }

    @Test
    void dictionarySize() {
        assertEquals(141, wordAnalysis.dictionarySize());
    }

    @Test
    void sizeOfCharacters() {
        assertEquals(1031, charAnalysis.size());
    }

    @Test
    void sizeOfWords() {
        assertEquals(268, wordAnalysis.size());
    }

    @Test
    void occurMoreThan() {
        Set<String> words = new HashSet<>(Arrays.asList("the", "and", "it"));
        assertEquals(words, wordAnalysis.occurMoreThan(10));
    }

    @Test
    void calculateOnePercentOfWords() {
        assertEquals(2, wordAnalysis.calculateOnePercentOfWords());
    }

    @Test
    void countVowelsPercentage() {
        assertEquals("40", charAnalysis.countVowelsPercentage());
    }

    @Test
    void countAERatio() {
        double ratio = 82.0 / 143.0;
        assertEquals(String.format("%.02f", ratio), charAnalysis.countAERatio());
    }

    @BeforeEach
    void redirectSystemOutStream() {
        originalOutput = System.out;
        currentOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(currentOutput));
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalOutput);
    }

    @Test
    void shouldShowLettersPercentage() {
        String test1 = "a ➛ 7.95%";
        String test2 = "o ➛ 7.37%";
        String test3 = "v ➛ 1.07%";

        charAnalysis.showLettersPercentage();

        assertThat(currentOutput.toString(), Matchers.containsString(test1));
        assertThat(currentOutput.toString(), Matchers.containsString(test2));
        assertThat(currentOutput.toString(), Matchers.containsString(test3));
    }
}