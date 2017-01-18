// https://judge.softuni.bg/Contests/Practice/Index/381#1
package org.lynxlake.multidimensionalArraysLab._02SumMatrixElements;

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

        int sum = 0;
        for (int[] number : numbers) {
            for (int i : number) {
                sum += i;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
