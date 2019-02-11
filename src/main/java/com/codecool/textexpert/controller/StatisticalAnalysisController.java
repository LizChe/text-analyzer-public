package com.codecool.textexpert.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.codecool.textexpert.dao.FileContent;
import com.codecool.textexpert.service.StatisticalAnalysis;
import com.codecool.textexpert.iterator.TextIterator;
import com.codecool.textexpert.view.View;

public class StatisticalAnalysisController {

    private View view;
    private String[] args;
    private TextIterator iterator;
    private StatisticalAnalysis wordAnalysis;
    private StatisticalAnalysis charAnalysis;

    public StatisticalAnalysisController(String[] args) {
        this.args = args;
        view = new View();
    }

    public void run() {
        long startTime = System.nanoTime();
        view.printLogo();
        for (String fileName : args) {
            iterator = new FileContent(fileName);
            wordAnalysis = new StatisticalAnalysis(iterator.wordIterator());
            charAnalysis = new StatisticalAnalysis(iterator.charIterator());
            showAnalysis(fileName);
        }
        long stopTime = System.nanoTime();
        double benchmarkTime = (stopTime - startTime) / 1E9;
        view.printMessage("𝕭𝖊𝖓𝖈𝖍𝖒𝖆𝖗𝖐 𝖙𝖎𝖒𝖊: " + benchmarkTime + " 𝖘𝖊𝖈𝖔𝖓𝖉𝖘");
    }

    private void showAnalysis(String fileName) {
        view.printMessage(fileName);
        view.printMessage("𝕮𝖍𝖆𝖗 𝖈𝖔𝖚𝖓𝖙: " + charAnalysis.size());
        view.printMessage("𝖂𝖔𝖗𝖉 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.size());
        view.printMessage("𝕯𝖎𝖈𝖙 𝖘𝖎𝖟𝖊: " + wordAnalysis.dictionarySize());
        view.printMessage("𝕷𝖔𝖛𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("love"));
        view.printMessage("𝕳𝖆𝖙𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("hate"));
        view.printMessage("𝔐𝖚𝖘𝖎𝖈 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("music"));
        view.printMessage("𝖁𝖔𝖜𝖊𝖑 𝖈𝖔𝖚𝖓𝖙 ⦅%⦆: " + countVowels());
        view.printMessage("𝖆:𝖊 𝖗𝖆𝖙𝖎𝖔: " + countAERatio());
        view.printMessage("𝕸𝖔𝖘𝖙 𝖚𝖘𝖊𝖉 𝖜𝖔𝖗𝖉𝖘 ⦅＜𝟙%⦆: \n" + wordAnalysis.occurMoreThan(calculateOnePercentOfUniqueWords()));
        view.printMessage("𝕻𝖊𝖗𝖈𝖊𝖓𝖙𝖆𝖌𝖊 𝖔𝖋 𝖆𝖑𝖑 𝖑𝖊𝖙𝖙𝖊𝖗𝖘: ");
        showLettersPercentage();
        view.printMessage("\n");
    }

    private int calculateOnePercentOfUniqueWords() {
        Double onePercentOfUniqueWords = 0.01 * wordAnalysis.size();
        int n = onePercentOfUniqueWords.intValue();
        return n;
    }

    private String countVowels() {
        double vowelsSum = charAnalysis.countOf("a", "e", "i", "o", "u", "y");
        double sumOfChars = charAnalysis.size();
        double percentage = (vowelsSum / sumOfChars) * 100;
        return String.format("%.0f", percentage);
    }

    private String countAERatio() {
        double countE = charAnalysis.countOf("e");
        double countA = charAnalysis.countOf("a");
        double ratio = countA / countE;
        return String.format("%.2f", ratio);
    }

    private void showLettersPercentage() {
        Set<String> uniqueChars = charAnalysis.getUniqueChars();
        Map<String, Double> charsPercentage = new HashMap<>();
        double sumOfChars = charAnalysis.size();

        for (String letter : uniqueChars) {
            double letterSum = charAnalysis.countOf(letter);
            double percentage = (letterSum / sumOfChars) * 100;
            charsPercentage.put(letter, percentage);
        }

        for (Map.Entry<String, Double> entry : charsPercentage.entrySet()) {
            System.out.printf("|%s -> %.0f%s| ", entry.getKey(), entry.getValue(), "%");
        }
    }
}