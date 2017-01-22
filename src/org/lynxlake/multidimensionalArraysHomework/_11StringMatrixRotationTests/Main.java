// https://judge.softuni.bg/Contests/Practice/Index/387#10
package org.lynxlake.multidimensionalArraysHomework._11StringMatrixRotationTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim();
        int degrees = Integer.parseInt(command.substring(command.indexOf('(') + 1, command.indexOf(')')));
        List<char[]> jaggedMatrix = new ArrayList<>();

        int pad = Integer.MIN_VALUE;
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            char[] chars = input.toCharArray();
            jaggedMatrix.add(chars);
            if (chars.length > pad) {
                pad = chars.length;
            }
        }

        // Pad the shorter lines with spaces at the end
        char[][] matrix = new char[jaggedMatrix.size()][pad];

        for (int i = 0; i < jaggedMatrix.size(); i++) {
            if (jaggedMatrix.get(i).length < pad) {
                char[] tmpMatrix = new char[pad];
                for (int j = 0; j < jaggedMatrix.get(i).length; j++) {
                    tmpMatrix[j] = jaggedMatrix.get(i)[j];
                }
                for (int j = jaggedMatrix.get(i).length; j < pad; j++) {
                    tmpMatrix[j] = ' ';
                }
                matrix[i] = tmpMatrix;
            } else {
                matrix[i] = jaggedMatrix.get(i);
            }
        }

        // Rotate the matrix to 90 degrees (degrees / 90) times
        while (degrees > 0) {
            matrix = rotate90degrees(matrix);
            degrees -= 90;
        }

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }

    }

    private static char[][] rotate90degrees(char[][] matrix) {
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        char[][] result = new char[maxCol + 1][maxRow + 1];

        int i = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            int j = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                result[i][j] = matrix[row][col];
                j++;
            }
            i++;
        }

        return result;
    }
}
