package com.codecool.textexpert.controller;

import com.codecool.textexpert.dao.FileContent;
import com.codecool.textexpert.service.StatisticalAnalysis;
import com.codecool.textexpert.view.View;

public class StatisticalAnalysisController {

    private View view;
    private String[] args;
    private StatisticalAnalysis wordAnalysis;
    private StatisticalAnalysis charAnalysis;

    public StatisticalAnalysisController(String[] args) {
        this.args = args;
        view = new View();
    }

    public void run() {
        FileContent fileContent;
        long startTime = System.nanoTime();
        view.printLogo();
        for (String fileName : args) {
            fileContent = new FileContent(fileName);
            view.printMessage(fileContent.getFileName());
            wordAnalysis = new StatisticalAnalysis(fileContent.wordIterator());
            charAnalysis = new StatisticalAnalysis(fileContent.charIterator());
            showAnalysis();
        }
        long stopTime = System.nanoTime();
        double benchmarkTime = (stopTime - startTime) / 1E9;
        view.printFormattedMessage("%s%.3f %s%n", "𝕭𝖊𝖓𝖈𝖍𝖒𝖆𝖗𝖐 𝖙𝖎𝖒𝖊: ", benchmarkTime,"𝖘𝖊𝖈𝖔𝖓𝖉𝖘");
    }

    private void showAnalysis() {
        view.printMessage("𝕮𝖍𝖆𝖗 𝖈𝖔𝖚𝖓𝖙: " + charAnalysis.size());
        view.printMessage("𝖂𝖔𝖗𝖉 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.size());
        view.printMessage("𝕯𝖎𝖈𝖙 𝖘𝖎𝖟𝖊: " + wordAnalysis.dictionarySize());
        view.printMessage("𝕷𝖔𝖛𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("love"));
        view.printMessage("𝕳𝖆𝖙𝖊 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("hate"));
        view.printMessage("𝔐𝖚𝖘𝖎𝖈 𝖈𝖔𝖚𝖓𝖙: " + wordAnalysis.countOf("music"));
        view.printMessage("𝖁𝖔𝖜𝖊𝖑 𝖈𝖔𝖚𝖓𝖙 ⦅%⦆: " + charAnalysis.countVowelsPercentage());
        view.printMessage("𝖆:𝖊 𝖗𝖆𝖙𝖎𝖔: " + charAnalysis.countAERatio());
        view.printMessage("𝕸𝖔𝖘𝖙 𝖚𝖘𝖊𝖉 𝖜𝖔𝖗𝖉𝖘 ⦅＜𝟙%⦆: \n" + wordAnalysis.occurMoreThan(wordAnalysis.calculateOnePercentOfWords()));
        view.printMessage("𝕻𝖊𝖗𝖈𝖊𝖓𝖙𝖆𝖌𝖊 𝖔𝖋 𝖆𝖑𝖑 𝖑𝖊𝖙𝖙𝖊𝖗𝖘: ");
        charAnalysis.showLettersPercentage();
        view.printMessage("\n");
    }
}