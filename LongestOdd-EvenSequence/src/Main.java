package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] numbersData = console.nextLine().split("[()]");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersData.length; i++) {
            String trimString = numbersData[i].trim();

            if (!trimString.equals("")) {
                int number = Integer.parseInt(trimString);
                numbers.add(number);
            }
        }

        int result = 0;
        if (numbers.size() == 1) {
            result = 1;
        } else {
            result = countSequence(numbers);
        }

        System.out.println(result);
    }

    private static int countSequence(List<Integer> list) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            int second = list.get(i + 1);

            if (((first % 2 == 0 || first == 0) && (second % 2 != 0 || second == 0))
                    || ((second % 2 == 0 || second == 0) && (first % 2 != 0 || first == 0))) {
                currentSum += 1;
            } else {
                currentSum = 0;
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }

        if(list.get(list.size() - 2) == 0 && list.get(list.size() - 1) != 0){
            return maxSum;
        }

        return maxSum + 1;
    }
}
