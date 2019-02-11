package com.codecool.textexpert.iterator;

import java.util.Iterator;

public interface TextIterator {

    public Iterator<String> charIterator();

    public Iterator<String> wordIterator();
}