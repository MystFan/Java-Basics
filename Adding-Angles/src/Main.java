package com.company;

import java.util.Scanner;

public class Main {

    static int k = 3;
    static int n;
    static boolean hasResult;
    static int[] numbers;
    static int[] arr;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        n = Integer.parseInt(console.nextLine());
        String anglesLine = console.nextLine();
        String[] angles = anglesLine.split(" ");

        numbers = new int[angles.length];
        for (int i = 0; i < angles.length; i++) {
            numbers[i] = Integer.parseInt(angles[i]);
        }

        arr = new int[k];
        generateCombinationsNoRepetitions(0, 0);

        if (!hasResult) {
            System.out.println("No");
        }
    }

    static int sum(int[] nums) {
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
        }

        return currentSum;
    }

    static void generateCombinationsNoRepetitions(int index, int start) {
        if (index >= k) {
            int[] numbersToSum = new int[k];
            for (int i = 0; i < arr.length; i++) {
                numbersToSum[i] = numbers[arr[i]];
            }

            int degrees = 360;
            int sum = sum(numbersToSum);
            if (sum >= degrees && (sum % degrees == 0)) {
                hasResult = true;
                System.out.println(numbersToSum[0] + " + " + numbersToSum[1] + " + " + numbersToSum[2] + " = " + sum + " degrees");
            }
        } else {
            for (int i = start; i < n; i++) {
                arr[index] = i;
                generateCombinationsNoRepetitions(index + 1, i + 1);
            }
        }
    }
}
