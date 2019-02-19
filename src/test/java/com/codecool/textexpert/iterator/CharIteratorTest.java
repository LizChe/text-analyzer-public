package com.codecool.textexpert.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codecool.textexpert.dao.FileContent;

class CharIteratorTest {

    private CharIterator charIterator;

    @BeforeEach
    void init() {
        charIterator = new CharIterator(new FileContent("src/test/resources/text_files/test2.txt"));
    }

    @Test
    void hasNextIsTrue() {
        assertTrue(charIterator.hasNext());
        charIterator.next();
        assertTrue(charIterator.hasNext());
    }

    @Test
    void hasNextIsFalseAfterLastElement() {
        for (int i = 1; i < 18; i ++) {
            charIterator.next();
        }
        assertFalse(charIterator.hasNext());
    }

    @Test
    void nextIsNotNull() {
        assertEquals(charIterator.next(), "t");
        assertEquals(charIterator.next(), "h");
        assertEquals(charIterator.next(), "a");
        assertEquals(charIterator.next(), "t");
    }

    @Test
    void nextIsNullIfAfterLastElement() {
        for (int i = 1; i < 18; i++) {
            charIterator.next();
        }
        assertNull(charIterator.next());
    }
}