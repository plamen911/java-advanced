// https://judge.softuni.bg/Contests/Practice/Index/188#15
package org.lynxlake._04SetsAndMapsExercises._16TargetPractice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        String snake = scanner.nextLine();
        String[] shotParameters = scanner.nextLine().split("\\s+");

        int numberOfRows = Integer.parseInt(dimensions[0]);
        int numberOfColumns = Integer.parseInt(dimensions[1]);

        int impactRow = Integer.parseInt(shotParameters[0]);
        int impactCol = Integer.parseInt(shotParameters[1]);
        int shotRadius = Integer.parseInt(shotParameters[2]);

        char[][] matrix = new char[numberOfRows][];

        fillMatrix(snake, matrix, numberOfColumns);

        fireAShot(matrix, impactRow, impactCol, shotRadius);

        dropCharacters(matrix);

        printMatrix(matrix);
    }

    private static void fillMatrix(String snake, char[][] matrix, int matrixWidth) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new char[matrixWidth];
        }

        boolean isMovingLeft = true;
        int currentSymbolIndex = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int col = isMovingLeft ? matrixWidth - 1 : 0;
            int colUpdate = isMovingLeft ? -1 : 1;

            while (0 <= col && col < matrixWidth) {
                if (currentSymbolIndex >= snake.length()) {
                    currentSymbolIndex = 0;
                }

                matrix[row][col] = snake.charAt(currentSymbolIndex);

                currentSymbolIndex++;
                col += colUpdate;
            }

            isMovingLeft = !isMovingLeft;
        }
    }

    private static void fireAShot(char[][] matrix, int impactRow, int impactCol, int shotRadius) {
        int matrixWidth = matrix[0].length;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrixWidth; col++) {
                if (isInsideRadius(row, col, impactRow, impactCol, shotRadius)) {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static boolean isInsideRadius(int checkRow, int checkCol, int impactRow, int impactCol, int shotRadius) {
        int deltaRow = checkRow - impactRow;
        int deltaCol = checkCol - impactCol;

        return deltaRow * deltaRow + deltaCol * deltaCol <= shotRadius * shotRadius;
    }

    private static void dropCharacters(char[][] matrix) {
        int width = matrix[0].length;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int column = 0; column < width; column++) {
                if (matrix[row][column] != ' ') {
                    continue;
                }

                int currentRow = row - 1;
                while (currentRow >= 0) {
                    if (matrix[currentRow][column] != ' ') {
                        matrix[row][column] = matrix[currentRow][column];
                        matrix[currentRow][column] = ' ';
                        break;
                    }

                    currentRow--;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        int matrixWidth = matrix[0].length;

        for (char[] aMatrix : matrix) {
            for (int col = 0; col < matrixWidth; col++) {
                System.out.print(aMatrix[col]);
            }

            System.out.println();
        }
    }
}
