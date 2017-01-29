// https://judge.softuni.bg/Contests/Practice/Index/383#2
package org.lynxlake.javaSyntaxExercises._03FormattingNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|%n",
                a,
                new BigInteger(Integer.toBinaryString(a)),
                b,
                c
        );
    }
}
