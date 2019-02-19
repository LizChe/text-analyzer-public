package com.codecool.textexpert.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codecool.textexpert.dao.FileContent;

class WordIteratorTest {

    private WordIterator wordIterator;

    @BeforeEach
    void init() {
        wordIterator = new WordIterator(new FileContent("src/test/resources/text_files/test2.txt"));
    }

    @Test
    void hasNextIsTrue() {
        assertTrue(wordIterator.hasNext());
        wordIterator.next();
        assertTrue(wordIterator.hasNext());
    }

    @Test
    void hasNextIsFalseAfterLastElement() {
        for (int i = 0; i < 4; i ++) {
            wordIterator.next();
        }
        assertFalse(wordIterator.hasNext());
    }

    @Test
    void nextIsNotNull() {
        assertEquals(wordIterator.next(), "that");
        assertEquals(wordIterator.next(), "is");
        assertEquals(wordIterator.next(), "another");
        assertEquals(wordIterator.next(), "text");
    }

    @Test
    void nextIsNullIfAfterLastElement() {
        for (int i = 0; i < 4; i++) {
            wordIterator.next();
        }
        assertNull(wordIterator.next());
    }
}