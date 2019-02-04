package com.codecool.textexpert.iterators;

import com.codecool.textexpert.dao.TextFileDao;

import java.util.Iterator;

public class CharIterator implements Iterator {

    private TextFileDao textFileDao;

    public CharIterator(TextFileDao textFileDao) {
        textFileDao = new TextFileDao(textFileDao.getFileName());
    }

    public boolean hasNext() {
        /**
         * Implement the method here
         */
    }

    public String next() {
        /**
         * Implement the method here
         */
    }

    public void remove() {
        /**
         * Implement the method here
         */
    }
}
