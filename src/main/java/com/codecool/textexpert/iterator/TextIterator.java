package com.codecool.textexpert.iterator;

import java.util.Iterator;

public interface TextIterator {

    Iterator<String> charIterator();

    Iterator<String> wordIterator();
}
