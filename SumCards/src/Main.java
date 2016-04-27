package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        String regex = "([0-9JQKA]+)([A-Z])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> cards = new ArrayList<>();
        while (matcher.find()) {
            String cardFace = matcher.group(1);
            cards.add(cardFace);
        }


        int sum = 0;
        int currentSum = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < cards.size() - 1; i++) {
            String first = cards.get(i);
            String second = cards.get(i + 1);

            if (first.equals(second)) {
                if(i == cards.size() - 2){
                    numbers.add(getValue(second));
                }

                numbers.add(getValue(first));
            } else {
                if(i == cards.size() - 2){
                    sum += getValue(second);
                }

                if (numbers.size() > 0) {
                    for (int j = 0; j < numbers.size(); j++) {
                        currentSum += numbers.get(j);
                    }

                    currentSum += getValue(first);
                    sum += (currentSum * 2);
                    numbers.clear();
                    currentSum = 0;
                } else {
                    sum += getValue(first);
                }
            }
        }

        currentSum = 0;
        if(numbers.size() > 0){
            for (int i = 0; i < numbers.size(); i++) {
                currentSum += numbers.get(i);
            }

            sum += currentSum * 2;
        }

        if(cards.size() == 1){
            System.out.println(getValue(cards.get(0)));
        }else {
            System.out.println(sum);
        }
    }

    public static int getValue(String card) {
        int result = 0;
        switch (card) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10": result = Integer.parseInt(card); break;
            case "J": result = 12; break;
            case "Q": result = 13; break;
            case "K": result = 14; break;
            case "A": result = 15; break;
        }

        return result;
    }
}
