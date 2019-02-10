package com.codecool.textexpert.service;

import java.util.Iterator;
import java.util.Set;

public class StatisticalAnalysis {

    private Iterator<String> iterator;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
    }
 
    public int countOf(String... elems) {
        /**
         * @return sum of all occurences of the elements given as arguments
         */
    }
 
    public int dictionarySize() {
        /**
         * @return the numbber of unique elements of the dataset
         */
    }
 
    public int size() {
        int counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            counter ++;
        }
        return counter;
    }
 
    public Set<String> occurMoreThan(Integer n) {
        /**
         * @return all the elements that occur more than n_times in the dataset
         */
    }
}
