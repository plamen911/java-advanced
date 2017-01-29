// https://judge.softuni.bg/Contests/Practice/Index/387#4
package org.lynxlake._02MultidimensionalArraysExercises._05MaximalSum;

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

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {

                Integer tmpValue = 0;
                Integer[][] tmpMatrix = new Integer[3][3];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tmpValue += matrix[i + k][j + l];
                        tmpMatrix[k][l] = matrix[i + k][j + l];
                    }
                }

                if (tmpValue > maxSumValue) {
                    maxSumValue = tmpValue;
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
