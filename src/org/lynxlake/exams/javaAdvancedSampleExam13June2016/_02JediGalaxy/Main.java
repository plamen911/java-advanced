// https://judge.softuni.bg/Contests/Practice/Index/216#1
package org.lynxlake.exams.javaAdvancedSampleExam13June2016._02JediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] matrix;
    private static long jediSum = 0L;
    private static int rows;
    private static int cols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        rows = Integer.valueOf(dimensions[0]);
        cols = Integer.valueOf(dimensions[1]);

        matrix = new int[rows][cols];
        buildMatrix();

        while (true) {
            String input = reader.readLine();
            if (input.equals("Let the Force be with you")) break;

            String[] coordinates = input.split(" ");
            int jediRow = Integer.valueOf(coordinates[0]);
            int jediCol = Integer.valueOf(coordinates[1]);

            coordinates = reader.readLine().split(" ");
            int evilRow = Integer.valueOf(coordinates[0]);
            int evilCol = Integer.valueOf(coordinates[1]);

            // process the dark path
            if (evilRow >= rows) {
                int shiftValue = evilRow - rows + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }

            if (evilCol >= cols) {
                int shiftValue = evilCol - cols + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }

            while (evilRow >= 0 && evilCol >= 0) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            //process the jedi path
            if (jediRow >= rows) {
                int shiftValue = jediRow - rows + 1;
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }

            if (jediCol < 0) {
                int shiftValue = Math.abs(jediCol);
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }

            while (jediRow >= 0 && jediCol < cols) {
                jediSum += matrix[jediRow][jediCol];
                jediRow--;
                jediCol++;
            }
        }

        System.out.println(jediSum);
    }

    private static void buildMatrix() {
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter++;
            }
        }
    }
}
