package com.codecool.textexpert.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.codecool.textexpert.dao.FileContent;

public class WordIterator implements Iterator<String> {

    private FileContent fileContent;
    private List<String> words;
    private int index;

    public WordIterator(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public boolean hasNext() {
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
        List<String> fileContentToParse = fileContent.getFileContent();
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : fileContentToParse) {
            stringBuilder.append(string);
        }
        words = Arrays.asList(stringBuilder.toString().split("\\s+"));
    }

    public List<String> getWords() {
        addWords(fileContent);
        return words;
    }
}