package com.company;

import java.util.Scanner;

public class Main {
    static int k = 4;
    static int numbersCount;
    static boolean hasResult;
    static boolean[] used;
    static int[] numbers;
    static int[] arr;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        numbersCount = console.nextInt();
        numbers = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            int number = console.nextInt();
            numbers[i] = number;
        }

        used = new boolean[numbersCount];
        arr = new int[k];

        if (numbers.length < 4) {
            System.out.println("No");
        } else {
            generateVariationsNoRepetitions(0);

            if (!hasResult) {
                System.out.println("No");
            }
        }
    }

    static void generateVariationsNoRepetitions(int index) {
        if (index >= k) {
            int[] numbersToCompare = new int[k];
            for (int i = 0; i < arr.length; i++) {
                numbersToCompare[i] = numbers[arr[i]];
            }

            String firstAppend = numbersToCompare[0] + "" + numbersToCompare[1];
            String secondAppend = numbersToCompare[2] + "" + numbersToCompare[3];
            if ((numbersToCompare[0] != numbersToCompare[1]) && firstAppend.equals(secondAppend)) {
                hasResult = true;
                String result = String.format("%s|%s==%s|%s", numbersToCompare[0], numbersToCompare[1], numbersToCompare[2], numbersToCompare[3]);
                System.out.println(result);
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
