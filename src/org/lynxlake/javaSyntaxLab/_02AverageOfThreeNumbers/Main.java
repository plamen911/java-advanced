// https://judge.softuni.bg/Contests/Practice/Index/382#1
package org.lynxlake.javaSyntaxLab._02AverageOfThreeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();

        System.out.printf("%.2f%n", (first + second + third) / 3);
        System.out.printf("%.2f", 2.0);
    }
}
