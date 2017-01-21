// https://judge.softuni.bg/Contests/Practice/Index/387#2
package org.lynxlake.multidimensionalArraysHomework._03DiagonalDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[][] matrix = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            // convert an integer string separated by space into an array
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        // Primary diagonal
        Integer primaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
        }

        // Secondary diagonal
        Integer secondaryDiagonalSum = 0;
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            secondaryDiagonalSum += matrix[i][j++];
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
