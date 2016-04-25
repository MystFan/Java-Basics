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

        int minutes = 0;
        int hours = 0;
        int currentMinutes = 0;
        int totalMinutes = 60;
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            String[] durationData = line.split(":");
            hours += Integer.parseInt(durationData[0]);
            currentMinutes = Integer.parseInt(durationData[1]);

            minutes += currentMinutes;

            if(minutes >= totalMinutes) {
                hours += 1;
                minutes -= totalMinutes;
            }

            currentMinutes = 0;
        }

        System.out.println(hours + ":" + (minutes < 10 ? "0" + minutes : minutes));
    }
}
