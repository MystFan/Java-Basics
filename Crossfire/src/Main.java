package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstLine = console.nextLine();
        String[] dimensions = firstLine.split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        int counter = 0;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                counter++;
                matrix.get(row).add(counter);
            }
        }

        String line = console.nextLine();
        List<String> commands = new ArrayList<>();
        while (!line.equals("Nuke it from orbit")){
            commands.add(line);
            line = console.nextLine();
        }

        for (int i = 0; i < commands.size(); i++) {
            String[] fireData = commands.get(i).split(" ");
            int row = Integer.parseInt(fireData[0]);
            int col = Integer.parseInt(fireData[1]);
            int radius = Integer.parseInt(fireData[2]);
            crossfire(matrix, row, col, radius);
        }

        printMatrix(matrix);
    }

    private static void crossfire(List<List<Integer>> matrix, int row, int col, int radius){
        int rowStartIndex = row - radius;
        int rowEndIndex = row + radius;
        int colStartIndex = col - radius;
        int colEndIndex = col + radius;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if((i >= rowStartIndex && i <= rowEndIndex) && j == col){
                    matrix.get(i).set(j, -1);
                }

                if((j >= colStartIndex && j <= colEndIndex) && i == row){
                    matrix.get(i).set(j, -1);
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            while (true) {
                int index = matrix.get(i).indexOf(-1);
                if (index < 0) {
                    break;
                }

                matrix.get(i).remove(index);
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix){
        for (int row = 0; row < matrix.size(); row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix.get(row).size(); col++) {
                sb.append(matrix.get(row).get(col));
                sb.append(" ");
            }

            if(sb.length() > 0) {
                System.out.println(sb.toString().trim());
            }
        }
    }
}
