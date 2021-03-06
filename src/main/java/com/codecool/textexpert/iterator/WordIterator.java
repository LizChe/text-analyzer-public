package com.codecool.textexpert.iterator;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.codecool.textexpert.dao.FileContent;

public class WordIterator implements Iterator<String> {

    private List<String> words;
    private int index;

    public WordIterator(FileContent fileContent) {
        addWords(fileContent);
    }

    @Override
    public boolean hasNext() {
        if (index == words.size()) {
            index = 0;
            return false;
        }
        return index < words.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return words.get(index++);
        }
        return null;
    }

    private void addWords(FileContent fileContent) {
        words = new ArrayList<>();
        List<String> fileContentToParse = fileContent.getFileContent();
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : fileContentToParse) {
            stringBuilder.append(string);
            stringBuilder.append("\n");
        }
        words = Arrays.asList(stringBuilder.toString().split("\\s+"));
    }
}