package org.lynxlake.multidimensionalArraysHomework._10PlusRemoveTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLines = new ArrayList<>();

        String currentInputLine = scanner.nextLine();

        while (!currentInputLine.equals("END")) {
            inputLines.add(currentInputLine);
            currentInputLine = scanner.nextLine();
        }

        List<char[]> result = new ArrayList<>();

        for (String line : inputLines) {
            result.add(line.toCharArray());
        }

        if (inputLines.size() <= 2) {
            for (String line : inputLines) {
                System.out.println(line);
            }
            return;
        }

        for (int i = 0; i < inputLines.size() - 2; i++) {
            for (int j = 0; j < inputLines.get(i).length(); ) {
                try {
                    char top = inputLines.get(i).toLowerCase().charAt(j);
                    char left = inputLines.get(i + 1).toLowerCase().charAt(j - 1);
                    char right = inputLines.get(i + 1).toLowerCase().charAt(j + 1);
                    char middle = inputLines.get(i + 1).toLowerCase().charAt(j);
                    char bottom = inputLines.get(i + 2).toLowerCase().charAt(j);

                    if (top == left && left == right && right == middle && middle == bottom) {
                        result.get(i)[j] = ' ';
                        result.get(i + 1)[j] = ' ';
                        result.get(i + 2)[j] = ' ';
                        result.get(i + 1)[j + 1] = ' ';
                        result.get(i + 1)[j - 1] = ' ';
                    }

                    j++;
                } catch (StringIndexOutOfBoundsException ex) {
                    j++;
                }
            }
        }

        for (char[] line : result) {
            for (char character : line) {
                if (character != ' ') {
                    System.out.print(character);
                }
            }
            System.out.println();
        }
    }
}
