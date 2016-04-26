package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String inputLine = console.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String currentNumberAsString = "";
        for (int i = 0; i < inputLine.length(); i++) {
            char symbol = inputLine.charAt(i);
            if (symbol > 47 && symbol < 58) {
                currentNumberAsString += symbol;
            }else{
                if(!currentNumberAsString.equals("")) {
                    numbers.add(Integer.parseInt(currentNumberAsString));
                    currentNumberAsString = "";
                }
            }
        }

        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i += 2) {
            Rectangle recangle = new Rectangle(numbers.get(i), numbers.get(i + 1));
            rectangles.add(recangle);
        }

        int currentSum = 0;
        int bestIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < rectangles.size() - 2; i++) {
            Rectangle firstRectangle = rectangles.get(i);
            Rectangle secondRectangle = rectangles.get(i + 1);
            Rectangle thirdRectangle = rectangles.get(i + 2);
            currentSum = (firstRectangle.sideA * firstRectangle.sideB) + (secondRectangle.sideA * secondRectangle.sideB) + (thirdRectangle.sideA * thirdRectangle.sideB);

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestIndex = i;
            }
        }

        int sumAreas = 0;
        for (int i = bestIndex; i < bestIndex + 3; i++) {
            Rectangle rectangle = rectangles.get(i);
            int area = rectangle.sideA * rectangle.sideB;
            sumAreas += area;
        }

        System.out.println(sumAreas);
    }
}

class Rectangle {
    public int sideA;
    public int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }
}
