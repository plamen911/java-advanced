// https://judge.softuni.bg/Contests/Practice/Index/92#0
package org.lynxlake.advancedCSharpExam19July2015._01BunkerBuster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split("\\s+");
        int numberOfRows = Integer.parseInt(dimensions[0]);
        int numberOfColumns = Integer.parseInt(dimensions[1]);

        long[][] matrix = new long[numberOfRows][numberOfColumns];

        // fill-in matrix
        for (int i = 0; i < numberOfRows; i++) {
            String[] cellInfo = reader.readLine().split("\\s+");
            for (int j = 0; j < numberOfColumns; j++) {
                matrix[i][j] = Long.parseLong(cellInfo[j]);
            }
        }

        // read commands
        String command;
        while (!"cease fire!".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\s+");
            int impactRow = Integer.parseInt(commandArgs[0]);
            int impactCol = Integer.parseInt(commandArgs[1]);
            int bombPower = (int)commandArgs[2].charAt(0);
            int reducedBombPower = (int)Math.ceil(bombPower / 2.0);

            for (int row = impactRow - 1; row <= impactRow + 1; row++) {
                for (int col = impactCol - 1; col <= impactCol + 1; col++) {
                    try {
                        if (row == impactRow && col == impactCol) {
                            matrix[row][col] -= bombPower;
                        } else {
                            matrix[row][col] -= reducedBombPower;
                        }
                    } catch (IndexOutOfBoundsException ignored) {

                    }
                }
            }
        }

        // count destroyed bunkers
        int numDestroyed = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                if (matrix[row][col] <= 0) {
                    numDestroyed++;
                }
            }
        }

        double totalDamage;
        if ((numberOfRows * numberOfColumns) > 0) {
            totalDamage = (double) numDestroyed / (numberOfRows * numberOfColumns) * 100;
        } else {
            totalDamage = 0;
        }

        System.out.printf("Destroyed bunkers: %d%n", numDestroyed);
        System.out.printf("Damage done: %.1f %%", (double)totalDamage);
    }
}
