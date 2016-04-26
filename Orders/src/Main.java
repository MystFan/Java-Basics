package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        String[] lines = new String[count];
        LinkedHashMap<String, TreeMap<String, Integer>> orders = new LinkedHashMap<>();
        for (int i = 0; i < lines.length; i++) {
            String line = console.nextLine();
            String[] orderData = line.split(" ");
            String keyProduct = orderData[2];
            String keyCustomerName = orderData[0];
            Integer value = Integer.parseInt(orderData[1]);

            if (!orders.containsKey(keyProduct)) {
                orders.put(keyProduct, new TreeMap<>());
            }

            if (!orders.get(keyProduct).containsKey(keyCustomerName)) {
                orders.get(keyProduct).put(keyCustomerName, 0);
            }

            int currentValue = orders.get(keyProduct).get(keyCustomerName);
            orders.get(keyProduct).put(keyCustomerName, currentValue + value);
        }

        for (String key : orders.keySet()) {
            List<Map.Entry<String, Integer>> pairs = new ArrayList<>(orders.get(key).entrySet());
            StringBuilder sb = new StringBuilder(key + ": ");
            for (int i = 0; i < pairs.size(); i++) {
                String outputLine = pairs.get(i).getKey() + " " + pairs.get(i).getValue();
                if (i < pairs.size() - 1) {
                    sb.append(outputLine + ", ");
                } else {
                    sb.append(outputLine);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
