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

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String currentNumberLine = console.nextLine();
            numbers[i] = Integer.parseInt(currentNumberLine);
        }

        arr = new int[k];
        generateVariationsWithRepetitions(0);

        if(!hasResult){
            System.out.println("No");
        }
    }

    static void generateVariationsWithRepetitions(int index) {
        if (index >= k) {
            int[] numbersToSum = new int[k];
            for (int i = 0; i < arr.length; i++) {
                numbersToSum[i] = numbers[arr[i]];
            }

            double a = Math.pow(numbersToSum[0], 2);
            double b = Math.pow(numbersToSum[1], 2);
            double c = Math.pow(numbersToSum[2], 2);

            if(a <= b && a + b == c){
                hasResult = true;
                System.out.println(numbersToSum[0] + "*" + numbersToSum[0] + " + " + numbersToSum[1] + "*" + numbersToSum[1] + " = " + numbersToSum[2] + "*" + numbersToSum[2]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[index] = i;
                generateVariationsWithRepetitions(index + 1);
            }
        }
    }
}
