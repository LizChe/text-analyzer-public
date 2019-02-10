package com.codecool.textexpert.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import com.codecool.textexpert.iterator.CharIterator;
import com.codecool.textexpert.iterator.TextIterator;
import com.codecool.textexpert.iterator.WordIterator;

public class FileContent implements TextIterator {

    private String fileName;
    private List<String> fileContent;

    public FileContent(String fileName) {
        this.fileName = fileName;
        loadFileContent(fileName);
    }

    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getFileContent() {
        return fileContent;
    }

    private void loadFileContent(String fileName) {
        fileContent = new ArrayList<>();
        Scanner textFile = null;

        try {
            textFile = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (textFile.hasNext()) {
            fileContent.add(textFile.nextLine());
        }
        textFile.close();
    }

}