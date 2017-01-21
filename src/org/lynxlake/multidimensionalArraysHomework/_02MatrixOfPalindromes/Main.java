// https://judge.softuni.bg/Contests/Practice/Index/387#1
package org.lynxlake.multidimensionalArraysHomework._02MatrixOfPalindromes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            int k = 0;
            for (int j = i; j < c + i; j++) {
                String palindrome = String.format("%s%s%s", alphabet[i], alphabet[j], alphabet[i]);
                matrix[i][k++] = palindrome;
            }
        }

        for (String[] strings : matrix) {
            System.out.printf("%s%n", String.join(" ", strings));
        }
    }
}
