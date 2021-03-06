// https://judge.softuni.bg/Contests/Practice/Index/188#20
package org.lynxlake._04SetsAndMapsExercises._21ParkingSystem;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int rows;
    private static int cols;
    private final static HashSet<String> takenSpots = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        sc.nextLine();
        while (true) {
            String[] input = sc.nextLine().split("\\s+");
            if (input[0].equalsIgnoreCase("stop")) {
                break;
            }

            int entryRow = Integer.parseInt(input[0]);
            int wantedRow = Integer.parseInt(input[1]);
            int wantedCol = Integer.parseInt(input[2]);
            int steps = Math.abs(wantedRow - entryRow) + wantedCol + 1;
            if (wantedCol >= cols || wantedCol <= 0) {
                System.out.printf("Row %d full%n", wantedRow);
                continue;
            }
            String wantedSpot = wantedRow + " " + wantedCol;
            if (takenSpots.contains(wantedSpot)) {
                int mod = 1;
                while (true) {
                    int newColLeft = tryParkLeft(mod, wantedCol, wantedRow, steps);
                    if (newColLeft > 0) {
                        steps = Math.abs(wantedRow - entryRow) + newColLeft + 1;
                        System.out.println(steps);
                        break;
                    }
                    int newColRight = tryParkRight(mod, wantedCol, wantedRow, steps);
                    if (newColRight > 0) {
                        steps = Math.abs(wantedRow - entryRow) + newColRight + 1;
                        System.out.println(steps);
                        break;
                    }
                    if (newColLeft == -2 && newColRight == -2) {
                        System.out.printf("Row %d full%n", wantedRow);
                        break;
                    }
                    mod++;
                }
            } else {
                takenSpots.add(wantedSpot);
                System.out.println(steps);
            }
        }

    }

    private static int tryParkRight(int mod, int wantedCol, int wantedRow, int steps) {
        int newCol = wantedCol + mod;
        if (newCol >= cols) {
            return -2;
        }

        String newSpot = wantedRow + " " + newCol;
        if (takenSpots.contains(newSpot)) {
            return -1;
        }
        takenSpots.add(newSpot);
        return newCol;
    }

    private static int tryParkLeft(int mod, int wantedCol, int wantedRow, int steps) {
        int newCol = wantedCol - mod;
        if (newCol <= 0) {
            return - 2;
        }

        String newSpot = wantedRow + " " + newCol;
        if (takenSpots.contains(newSpot)) {
            return -1;
        }
        takenSpots.add(newSpot);
        return newCol;
    }
}
