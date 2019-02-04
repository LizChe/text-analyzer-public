package com.codecool.textexpert.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.codecool.textexpert.dao.FileContent;

public class CharIterator implements Iterator<String> {

    private FileContent fileContent;
    private List<String> chars;
    private int index;

    public CharIterator(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public boolean hasNext() {
        return index < chars.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return chars.get(index++);
        }
        return null;
    }

    private void addChars(FileContent fileContent) {
        List<String> fileContentToParse = fileContent.getFileContent();
        chars = new ArrayList<>();

        for (char letter : fileContentToParse.toString().toCharArray()) {
            if (Character.isLetter(letter)) {
                chars.add(Character.toString(letter));
            }
        }
    }

    public List<String> getChars() {
        addChars(fileContent);
        return chars;
    }
}