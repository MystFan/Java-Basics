package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();
        String[] numbersAsStrings = line.split("[ )(]");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersAsStrings.length; i++) {
            if (!numbersAsStrings[i].equals("")) {
                int number = Integer.parseInt(numbersAsStrings[i]);
                numbers.add(number);
            }
        }

        List<Integer> uniquePrimes = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > 1 && isPrimeNumber(currentNumber) && !(uniquePrimes.contains(currentNumber))) {
                uniquePrimes.add(currentNumber);
            }
        }

        Collections.sort(uniquePrimes, (n1, n2) -> n2 - n1);

        if (uniquePrimes.size() >= 3) {
            System.out.println(uniquePrimes.get(0) + uniquePrimes.get(1) + uniquePrimes.get(2));
        } else {
            System.out.println("No");
        }
    }

    public static boolean isPrimeNumber(int number) {
        double maxDivider = Math.sqrt(number);
        boolean isPrime = true;

        for (int i = 2; i <= maxDivider; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
