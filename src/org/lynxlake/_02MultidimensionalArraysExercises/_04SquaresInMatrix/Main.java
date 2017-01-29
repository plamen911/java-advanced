// https://judge.softuni.bg/Contests/Practice/Index/387#3
package org.lynxlake._02MultidimensionalArraysExercises._04SquaresInMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().trim().split("\\s+");
        }

        int numSquares = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                String a11 = matrix[i][j];
                String a12 = matrix[i][j + 1];
                String a21 = matrix[i + 1][j];
                String a22 = matrix[i + 1][j + 1];
                if (a11.equals(a12) && a11.equals(a21) && a11.equals(a22)) {
                    numSquares++;
                }
            }
        }

        System.out.println(numSquares);
    }
}
