// https://judge.softuni.bg/Contests/Practice/Index/276#1
package org.lynxlake.exams.retakeExam22August2016._02NaturesProphet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split("\\s+");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        int[][] garden = new int[n][m];

        String line;
        while (!"Bloom Bloom Plow".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            garden[row][col] += 1;

            // bloom horizontally
            for (int i = 0; i < n; i++) {
                if (i == col) continue;
                garden[row][i] += 1;
            }
            for (int i = 0; i < m; i++) {
                if (i == row) continue;
                garden[i][col] += 1;
            }
        }

        for (int[] rows : garden) {
            for (int col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
