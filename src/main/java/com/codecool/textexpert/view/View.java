package com.codecool.textexpert.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFormattedMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    public void printLogo() {
        Scanner logoFile = null;
        StringBuilder logo = new StringBuilder();

        try {
            logoFile = new Scanner(new File("src/main/resources/ui/logo.txt"));
        } catch (FileNotFoundException e) {
            printMessage(e.getMessage());
        }

        while (logoFile.hasNext()) {
            logo.append(logoFile.nextLine()).append("\n");
        }
        printMessage(logo.toString());
    }
}