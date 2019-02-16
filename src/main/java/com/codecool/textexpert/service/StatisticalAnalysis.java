package com.codecool.textexpert.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.codecool.textexpert.view.View;

public class StatisticalAnalysis {

    private Iterator<String> iterator;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
    }

    public int countOf(String... elements) {
        int counter = 0;
        while (iterator.hasNext()) {
            if (Arrays.stream(elements).anyMatch(iterator.next()::equalsIgnoreCase)) {
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

        Set<String> occurredMoreThanN = new HashSet<>();
        for (String key : countOfUniqueWords.keySet()) {
            if (countOfUniqueWords.get(key) > n) {
                occurredMoreThanN.add(key);
            }
        }
        return occurredMoreThanN;
    }

    public int calculateOnePercentOfWords() {
        Double onePercentOfWords = 0.01 * size();
        return onePercentOfWords.intValue();
    }

    public String countVowelsPercentage() {
        double vowelsSum = countOf("a", "e", "i", "o", "u", "y");
        double sumOfChars = size();
        double percentage = (vowelsSum / sumOfChars) * 100;
        return String.format("%.0f", percentage);
    }

    public String countAERatio() {
        double countE = countOf("e");
        double countA = countOf("a");
        double ratio = countA / countE;
        return String.format("%.2f", ratio);
    }

    public void showLettersPercentage() {
        View view = new View();
        Set<String> uniqueChars = getUniqueChars();
        Map<String, Double> charsPercentage = new HashMap<>();
        double sumOfChars = size();

        for (String letter : uniqueChars) {
            double letterSum = countOf(letter);
            double percentage = (letterSum / sumOfChars) * 100;
            charsPercentage.put(letter, percentage);
        }

        for (Map.Entry<String, Double> entry : charsPercentage.entrySet()) {
            view.printFormattedMessage("[%s ➛ %.2f%s] ", entry.getKey(), entry.getValue(), "%");
        }
    }

    private Set<String> getUniqueChars() {
        Set<String> uniqueChars = new HashSet<>();
        while (iterator.hasNext()) {
            String letter = iterator.next();
            uniqueChars.add(letter);
        }
        return uniqueChars;
    }
}