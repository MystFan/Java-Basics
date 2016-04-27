package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        String signsRegex = "(-|\\+)";
        String[] numbersData = input.split("[-+]+");

        Pattern signsPattern = Pattern.compile(signsRegex);
        Matcher signsMatcher = signsPattern.matcher(input);

        List<String> signs = new ArrayList<>();
        while (signsMatcher.find()) {
            String sign = signsMatcher.group(0);
            signs.add(sign);
        }

        BigDecimal sum = new BigDecimal(numbersData[0].trim());
        for (int i = 1; i < numbersData.length; i++) {
            BigDecimal number = new BigDecimal(numbersData[i].trim());
            String sign = signs.get(i - 1);
            if (sign.equals("+")) {
                sum = sum.add(number);
            } else {
                sum = sum.subtract(number);
            }
        }

        System.out.println(sum.toPlainString());
    }
}
