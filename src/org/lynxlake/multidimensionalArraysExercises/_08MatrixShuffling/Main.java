// https://judge.softuni.bg/Contests/Practice/Index/387#7
package org.lynxlake.multidimensionalArraysExercises._08MatrixShuffling;

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

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("END")) {
                break;
            }

            String[] commands = input.split("\\s+");
            if (commands.length != 5 || !commands[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            int x1 = Integer.parseInt(commands[1]);
            int y1 = Integer.parseInt(commands[2]);
            int x2 = Integer.parseInt(commands[3]);
            int y2 = Integer.parseInt(commands[4]);

            try {
                String tmp = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = tmp;

                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.printf("%s ", string);
                    }
                    System.out.println();
                }

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Invalid input!");
            }
        }
    }
}
