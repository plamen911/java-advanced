// https://judge.softuni.bg/Contests/Practice/Index/381#4
package org.lynxlake._02MultidimensionalArraysLab._05PascalTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        long[][] pascal = new long[height][];

        for (int i = 0; i < height; i++) {
            pascal[i] = new long[i + 1];
        }

        if (height > 0) {
            pascal[0][0] = 1;
            for (int row = 1; row < height; row++) {
                for (int col = 0; col <= row; col++) {
                    long aboveLeft = (col - 1 < 0) ? 0 : pascal[row - 1][col - 1];
                    long aboveRight = (col >= row) ? 0 : pascal[row - 1][col];
                    pascal[row][col] = aboveLeft + aboveRight;
                }
            }

            for (long[] ints : pascal) {
                for (long anInt : ints) {
                    System.out.printf("%d ", anInt);
                }
                System.out.println();
            }
        }
    }
}
