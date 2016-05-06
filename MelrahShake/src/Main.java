package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        String pattern = console.nextLine();

        StringBuilder currentPattern = new StringBuilder();
        currentPattern.append(pattern);
        StringBuilder currentText = new StringBuilder();
        currentText.append(input);
        while (true){
            String patternString = currentPattern.toString();
            int firstMatchIndex = currentText.indexOf(patternString);
            int lastMatchIndex = currentText.lastIndexOf(patternString);
            if(firstMatchIndex == lastMatchIndex || patternString.equals("")){
                System.out.println("No shake.");
                break;
            }

            currentText.replace(firstMatchIndex, firstMatchIndex + patternString.length(), "");
            lastMatchIndex = currentText.lastIndexOf(patternString);
            currentText.replace(lastMatchIndex, lastMatchIndex + patternString.length(), "");
            System.out.println("Shaked it.");
            int middleIndex = currentPattern.length() / 2;
            currentPattern.replace(middleIndex, middleIndex + 1, "");
        }

        System.out.println(currentText.toString());
    }
}
