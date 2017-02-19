// https://judge.softuni.bg/Contests/Compete/Index/470#1
package org.lynxlake.exams.javaFundamentalsExam19Feb2017._01Shockwave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int m;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        matrix = new int[n][m];

        String line;
        while (!"Here We Go".equals(line = reader.readLine().trim())) {
            String[] coords = line.split("\\s+");
            int x1 = Integer.parseInt(coords[0]);
            int y1 = Integer.parseInt(coords[1]);
            int x2 = Integer.parseInt(coords[2]);
            int y2 = Integer.parseInt(coords[3]);
            populateMatrix(x1, y1, x2, y2);
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void populateMatrix(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= x1 && i <= x2 && j >= y1 && j <= y2) {
                    matrix[i][j]++;
                }
            }
        }
    }
}
