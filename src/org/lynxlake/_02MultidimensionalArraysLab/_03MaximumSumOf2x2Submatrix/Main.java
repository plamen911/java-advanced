// https://judge.softuni.bg/Contests/Practice/Index/381#2
package org.lynxlake._02MultidimensionalArraysLab._03MaximumSumOf2x2Submatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int rows = Integer.parseInt(input[0].trim());
        int cols = Integer.parseInt(input[1].trim());
        int[][] numbers = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            input = scanner.nextLine().split(",");
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = Integer.parseInt(input[j].trim());
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int x00 = numbers[i][j];
                int x01 = numbers[i][j + 1];
                int x10 = numbers[i + 1][j];
                int x11 = numbers[i + 1][j + 1];

                int sum = x00 + x01 + x10 + x11;

                if (sum > maxSum) {
                    maxSum = sum;
                    subMatrix[0][0] = x00;
                    subMatrix[0][1] = x01;
                    subMatrix[1][0] = x10;
                    subMatrix[1][1] = x11;
                }
            }
        }

        for (int[] ints : subMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }
}
