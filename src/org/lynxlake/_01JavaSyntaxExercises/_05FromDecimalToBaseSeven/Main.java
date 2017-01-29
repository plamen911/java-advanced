// https://judge.softuni.bg/Contests/Practice/Index/383#4
package org.lynxlake._01JavaSyntaxExercises._05FromDecimalToBaseSeven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.printf("%s", toBaseSeven(n));
    }

    private static String toBaseSeven(long number) {
        int baseToConvertTo = 7;
        return Long.toString(number, baseToConvertTo);
    }
}
