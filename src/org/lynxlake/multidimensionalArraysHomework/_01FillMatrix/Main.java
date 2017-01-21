// https://judge.softuni.bg/Contests/Practice/Index/387#0
package org.lynxlake.multidimensionalArraysHomework._01FillMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(",\\s*");
        int n = Integer.parseInt(params[0]);

        int[][] matrix = new int[n][n];

        switch (params[1]) {
            case "A":
                matrix = fillWithPatternA(n);
                break;

            case "B":
                matrix = fillWithPatternB(n);
                break;
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static int[][] fillWithPatternA(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = j * n + i + 1;
                matrix[i][j] = number;
            }
        }

        return matrix;
    }

    private static int[][] fillWithPatternB(int n) {
        int[][] baseMatrix = fillWithPatternA(n);
        int[][] matrix = fillWithPatternA(n);

        for (int i = 1; i < n; i += 2) {
            int k = n - 1;
            for (int j = 0; j < n; j++) {
                matrix[j][i] = baseMatrix[k][i];
                k--;
            }
        }

        return matrix;
    }
}
