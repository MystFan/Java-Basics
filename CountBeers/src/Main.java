package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> inputLines = new ArrayList<>();
        while (true){
            String line = console.nextLine();
            if(line.trim().equals("End")){
                break;
            }

            inputLines.add(line);
        }

        int beers = 0;
        int stacks = 0;
        int currentBeers = 0;
        int totalBeers = 20;
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            String[] beersData = line.split(" ");

            if(beersData[1].equals("stacks")){
                stacks += Integer.parseInt(beersData[0]);
            }

            if(beersData[1].equals("beers")){
                currentBeers = Integer.parseInt(beersData[0]);
                beers += currentBeers;
            }

            while(beers >= totalBeers){
                stacks += 1;
                beers -= totalBeers;
            }

            currentBeers = 0;
        }

        System.out.printf("%d stacks + %d beers%n", stacks, beers);
    }
}
