// https://judge.softuni.bg/Contests/Practice/Index/383#3
package org.lynxlake.javaSyntaxHomework._04CalculateExpression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double pow = (a + b + c) / Math.sqrt(c);
        double f1 = Math.pow(((Math.pow(a, 2f) + Math.pow(b, 2f)) / (Math.pow(a, 2f) - Math.pow(b, 2f))), pow);

        pow = a - b;
        double f2 = Math.pow((Math.pow(a, 2f) + Math.pow(b, 2f) - Math.pow(c, 3f)), pow);

        double diff = Math.abs(((a + b + c) / 3f) - ((f1 + f2) / 2f));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}
