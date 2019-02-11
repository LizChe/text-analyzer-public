package com.codecool.textexpert.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StatisticalAnalysis {

    private Iterator<String> iterator;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
    }

    public int countOf(String... elems) {
        int counter = 0;
        while (iterator.hasNext()) {
            if (Arrays.stream(elems).anyMatch(iterator.next()::equals)) {
                counter++;
            }
        }
        return counter;
    }

    public int dictionarySize() {
        Set<String> uniqueWords = new HashSet<>();
        while (iterator.hasNext()) {
            uniqueWords.add(iterator.next());
        }
        return uniqueWords.size();
    }

    public int size() {
        int counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        return counter;
    }

    public Set<String> occurMoreThan(Integer n) {
        Map<String, Integer> countOfUniqueWords = new HashMap<>();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (countOfUniqueWords.containsKey(word)) {
                countOfUniqueWords.put(word, countOfUniqueWords.get(word) + 1);
            } else {
                countOfUniqueWords.put(word, 1);
            }
        }

        Set<String> occuredMoreThanN = new HashSet<>();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (countOfUniqueWords.get(word) > n && !countOfUniqueWords.containsKey(word)) {
                occuredMoreThanN.add(word);
            }
        }
        return occuredMoreThanN;
    }
}
