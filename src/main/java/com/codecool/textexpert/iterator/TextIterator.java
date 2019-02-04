package com.codecool.textexpert.iterators;

import java.util.Iterator;

public interface TextIterator {

    Iterator<String> charIterator();

    Iterator<String> wordIterator();
}
