package com.codecool.textexpert.controller;

import com.codecool.textexpert.dao.FileContent;
import com.codecool.textexpert.service.StatisticalAnalysis;
import com.codecool.textexpert.iterator.TextIterator;
import com.codecool.textexpert.view.View;

public class StatisticalAnalysisController {

    private View view;
    private String[] args;
    private FileContent fileContent;
    private TextIterator iterator;
    private StatisticalAnalysis wordAnalysis;
    private StatisticalAnalysis charAnalysis;

    public StatisticalAnalysisController(String[] args) {
        this.args = args;
        view = new View();
        wordAnalysis = new StatisticalAnalysis(iterator.wordIterator());
        charAnalysis = new StatisticalAnalysis(iterator.charIterator());
    }

    public void run() {
        long startTime = System.nanoTime();
        view.printLogo();
        for (String fileName : args) {
            fileContent = new FileContent(fileName);
            showAnalysis(fileName);
        }
        long stopTime = System.nanoTime();
        double benchmarkTime = (stopTime - startTime) / 1E9;
        view.printMessage("Benchmark time: " + benchmarkTime + " seconds");
    }

    private void showAnalysis(String fileName) {
        view.printMessage("𝕮𝖍𝖆𝖗 𝖈𝖔𝖚𝖓𝖙: " + charAnalysis.size());
        view.printMessage("𝖂𝖔𝖗𝖉 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.size());
        view.printMessage("𝕯𝖎𝖈𝖙 𝖘𝖎𝖟𝖊: " + wordAnalysis.dictionarySize());
        view.printMessage("𝕸𝖔𝖘𝖙 𝖚𝖘𝖊𝖉 𝖜𝖔𝖗𝖉𝖘 ⦅＜𝟙%⦆: " + wordAnalysis.occurMoreThan(calculateOnePercentOfUniqueWords()));
        view.printMessage("𝕷𝖔𝖛𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("love"));
        view.printMessage("𝕳𝖆𝖙𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("hate"));
        view.printMessage("𝔐𝖚𝖘𝖎𝖈 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("music"));
        view.printMessage("𝖁𝖔𝖜𝖊𝖑 𝖈𝖔𝖚𝖓𝖙 ⦅%⦆: " + countVowels());
        view.printMessage("𝖆:𝖊 𝖗𝖆𝖙𝖎𝖔: " + countAERatio());
    }

    private int calculateOnePercentOfUniqueWords() {
        Double onePercentOfUniqueWords = 0.01 * wordAnalysis.size();
        int n = onePercentOfUniqueWords.intValue();
        return n;
    }

    private int countVowels() {
        int vowelsSum = charAnalysis.countOf("a", "e", "i", "o", "u", "y");
        int sumOfChars = charAnalysis.size();
        return (vowelsSum * 100) / sumOfChars; //(vowelsSum / sumOfChars) * 100; <- TODO: Check if it works in the same way
    }

    private double countAERatio() {
        int countE = charAnalysis.countOf("e");
        int countA = charAnalysis.countOf("a");
        return countA / countE;
    }
}