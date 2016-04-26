package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String nAsString = console.nextLine();
        int n = Integer.parseInt(nAsString);


        List<BigDecimal> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String numberAsString = console.nextLine().trim();
            BigDecimal number = new BigDecimal(numberAsString);
            numbers.add(number);
        }

        List<BigDecimal> result = numbers.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int outputCount = result.size() >= 3 ? 3 : result.size();
        for (int i = 0; i < outputCount; i++) {
            System.out.println(result.get(i).toPlainString());
        }
    }
}
