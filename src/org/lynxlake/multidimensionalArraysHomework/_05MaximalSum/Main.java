// https://judge.softuni.bg/Contests/Practice/Index/387#4
package org.lynxlake.multidimensionalArraysHomework._05MaximalSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Integer[][] matrix = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Integer maxSumValue = Integer.MIN_VALUE;
        Integer[][] maxSumMatrix = new Integer[3][3];

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m - 3; j++) {

                Integer tmpSum = 0;
                Integer[][] tmpMatrix = new Integer[3][3];
                int rows = 0;
                int cols = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {

                        System.out.println("k: " + k + " l: " + l + " / " + matrix[k][l]);

                        // maxSumMatrix[k][l] = matrix[k][l];
                        // maxSumMatrix[rows][cols] = matrix[k][l];
                        // tmpSum += matrix[k][l];
                        cols++;
                    }

                    rows++;
                }

                System.out.println();

                if (tmpSum > maxSumValue) {
                    maxSumValue = tmpSum;
                    maxSumMatrix = tmpMatrix;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSumValue);
        for (Integer[] integers : maxSumMatrix) {
            for (Integer integer : integers) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }
}
