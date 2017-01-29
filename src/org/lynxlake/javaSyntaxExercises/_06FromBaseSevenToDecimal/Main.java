// https://judge.softuni.bg/Contests/Practice/Index/383#5
package org.lynxlake.javaSyntaxExercises._06FromBaseSevenToDecimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.printf("%d", fromBaseSeven(n));
    }

    private static String toBaseSeven(long number) {
        int baseToConvertTo = 7;
        return Long.toString(number, baseToConvertTo);
    }

    private static long fromBaseSeven(long number) {
        long i = number;
        while (true) {
            if (Integer.parseInt(toBaseSeven(i)) == number) {
                return i;
            }
            i--;
        }
    }
}
