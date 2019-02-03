package com.codecool.textexpert.models;

import com.codecool.textexpert.iterators.CharIterator;
import com.codecool.textexpert.iterators.TextIterator;
import com.codecool.textexpert.iterators.WordIterator;

import java.util.Iterator;

public class FileContent implements TextIterator {

    private String fileName;

    public FileContent(String fileName) {
        this.fileName = fileName;
    }

    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }

    public String getFileName() {
        return fileName;
    }
}
