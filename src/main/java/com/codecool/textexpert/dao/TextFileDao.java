package com.codecool.textexpert.dao;

import com.codecool.textexpert.iterators.TextIterator;

import java.util.Iterator;

public class TextFileDao implements TextIterator {

    private String fileName;

    public TextFileDao(String fileName) {
        this.fileName = fileName;
    }

    public Iterator<String> charIterator() {
        /**
         * Implement the method here
         */
    }

    public Iterator<String> wordIterator() {
        /**
         * Implement the method here
         */
    }

    public String getFileName() {
        return fileName;
    }
}
