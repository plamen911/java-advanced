// https://judge.softuni.bg/Contests/Practice/Index/91#1
package org.lynxlake.exams.advancedCSharpExam31May2015._02TargetPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        String snake = reader.readLine().trim();
        String[] command = reader.readLine().trim().split("\\s+");

        matrix = new String[n][m];

        populateMatrix(snake, n, m);

        shootInMatrix(command);

        elementsFall();

        printMatrix();
    }

    private static void elementsFall() {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (String[] aMatrix : matrix) {
                if (!aMatrix[i].equals(" ")) {
                    stack.add(aMatrix[i]);
                }
            }

            for (int j = matrix.length - 1; j >= 0; j--) {
                if (stack.size() != 0) {
                    matrix[j][i] = stack.pop();
                } else {
                    matrix[j][i] = " ";
                }
            }
        }
    }

    private static void shootInMatrix(String[] command) {
        int impactRow = Integer.parseInt(command[0]);
        int impactCol = Integer.parseInt(command[1]);
        int radius = Integer.parseInt(command[2]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isInsideCircle(i, j, impactRow, impactCol, radius)) {
                    try {
                        matrix[i][j] = " ";
                    } catch (IndexOutOfBoundsException ignored) {}
                }
            }
        }
    }

    // formula for points inside circle
    private static boolean isInsideCircle(int x, int y, int cCentX, int cCentY, int radius) {
        return Math.pow((x - cCentX), 2) + Math.pow((y - cCentY), 2) <= Math.pow(radius, 2);
    }

    // formula for points inside horizontal rectangle
    private static boolean isInsideRectangle(int x, int y, int rLeft, int rWidth, int rTop, int rHeight) {
        return (x >= rLeft) && (x <= (rLeft + rWidth)) && (y <= rTop) && (y >= (rTop - rHeight));
    }

    private static void populateMatrix(String snake, int n, int m) {
        int charIndex = 0;
        boolean isMovingLeft = false;
        for (int row = n - 1; row >= 0; row--) {
            if (!isMovingLeft) {
                isMovingLeft = true;
                for (int col = m - 1; col >= 0; col--) {
                    matrix[row][col] = String.valueOf(snake.charAt(charIndex++));
                    if (snake.length() <= charIndex) {
                        charIndex = 0;
                    }
                }
            } else {
                isMovingLeft = false;
                for (int j = 0; j < m; j++) {
                    matrix[row][j] = String.valueOf(snake.charAt(charIndex++));
                    if (snake.length() <= charIndex) {
                        charIndex = 0;
                    }
                }
            }
        }
    }

    private static void printMatrix() {
        for (String[] row : matrix) {
            for (String s : row) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println();
    }
}
