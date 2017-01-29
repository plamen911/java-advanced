// https://judge.softuni.bg/Contests/Practice/Index/383#10
package org.lynxlake.javaSyntaxExercises._11GameOfNames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String winnerName = "";
        long winnerPoints = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            long score = calcScore(Long.parseLong(scanner.nextLine()), name);
            if (score > winnerPoints) {
                winnerName = name;
                winnerPoints = score;
            }
        }

        System.out.printf("The winner is %s - %d points%n", winnerName, winnerPoints);
    }

    private static long calcScore(long score, String name) {
        for (int i = 0; i < name.length(); i++) {
            int ch = name.charAt(i);
            if (ch % 2 == 0) {
                score += ch;
            } else {
                score -= ch;
            }
        }

        return score;
    }
}
