package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        String[] numbersAsString = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.length; i++) {
            numbers.add(Integer.parseInt(numbersAsString[i]));
        }

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            String couple = numbers.get(i) + " " + numbers.get(i + 1);
            if(!map.containsKey(couple)){
                map.put(couple, 0);
            }

            int count = map.get(couple);
            map.put(couple, ++count);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getValue();
        }

        double onePersent = (double) 100 / sum;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i).getValue();
            System.out.printf("%s -> %.2f%%%n", list.get(i).getKey(), value * onePersent);
        }
    }
}

