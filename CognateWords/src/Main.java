package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int uniqueWordsSetCount = 3;
    static int numbersCount;
    static boolean hasResult;
    static boolean[] used;
    static List<String> words;
    static TreeSet<String> uniqueWordsSet;
    static int[] arr;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();
        String regex = "([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group(0));
        }

        numbersCount = words.size();
        used = new boolean[numbersCount];
        arr = new int[uniqueWordsSetCount];
        uniqueWordsSet = new TreeSet<>();

        generateVariationsNoRepetitions(0);

        if(!hasResult){
            System.out.println("No");
        }else{
            for (String wordItem : uniqueWordsSet) {
                System.out.println(wordItem);
            }
        }
    }

    static void generateVariationsNoRepetitions(int index) {
        if (index >= uniqueWordsSetCount) {
            String[] wordsSet = new String[uniqueWordsSetCount];
            for (int i = 0; i < arr.length; i++) {
                wordsSet[i] = words.get(arr[i]);
            }

            if ((wordsSet[0] + wordsSet[1]).equals(wordsSet[2])) {
                hasResult = true;
                String result = String.format("%s|%s=%s", wordsSet[0], wordsSet[1], wordsSet[2]);
                uniqueWordsSet.add(result);
            }
        } else {
            for (int i = 0; i < numbersCount; i++) {
                if (!used[i]) {
                    used[i] = true;
                    arr[index] = i;
                    generateVariationsNoRepetitions(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}
