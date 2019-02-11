package com.codecool.textexpert.main;

import com.codecool.textexpert.controller.StatisticalAnalysisController;

public class Main {
    public static void main(String[] args) {
        StatisticalAnalysisController controller = new StatisticalAnalysisController(args);
        controller.run();
    }
}