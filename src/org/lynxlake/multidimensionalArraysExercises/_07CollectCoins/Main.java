// https://judge.softuni.bg/Contests/Practice/Index/387#6
package org.lynxlake.multidimensionalArraysExercises._07CollectCoins;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[4][];
        for (int i = 0; i < 4; i++) {
            board[i] = scanner.nextLine().trim().toCharArray();
        }
        char[] commands = scanner.nextLine().trim().toCharArray();

        int coins = 0;
        int hits = 0;
        int startX = 0;
        int startY = 0;

        for (char command : commands) {
            int tmpX = startX;
            int tmpY = startY;
            switch (command) {
                case '>':
                    tmpY++;
                    break;
                case '<':
                    tmpY--;
                    break;
                case '^':
                    tmpX--;
                    break;
                case 'V':
                    tmpX++;
                    break;
                default:
                    continue;
            }

            try {
                char c = board[tmpX][tmpY];
                startX = tmpX;
                startY = tmpY;
                if (c == '$') {
                    coins++;
                }
            } catch (IndexOutOfBoundsException ex) {
                hits++;
            }
        }

        System.out.printf("Coins = %d%n", coins);
        System.out.printf("Walls = %d%n", hits);
    }
}
