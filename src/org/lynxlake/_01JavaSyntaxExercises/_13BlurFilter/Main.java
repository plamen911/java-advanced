// https://judge.softuni.bg/Contests/Practice/Index/383#12
package org.lynxlake._01JavaSyntaxExercises._13BlurFilter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long blurAmount = Long.parseLong(scanner.nextLine());
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Long.parseLong(numbers[j]);
            }
        }

        int blurRow = scanner.nextInt();
        int blurCol = scanner.nextInt();

        // blur
        for (int i = blurRow - 1; i <= blurRow + 1; i++) {
            for (int j = blurCol - 1; j <= blurCol + 1; j++) {
                try {
                    matrix[i][j] += blurAmount;
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
        }

        for (long[] ints : matrix) {
            for (long anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}
