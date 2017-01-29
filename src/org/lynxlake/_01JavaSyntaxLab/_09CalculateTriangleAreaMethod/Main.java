// https://judge.softuni.bg/Contests/Practice/Index/382#8
package org.lynxlake._01JavaSyntaxLab._09CalculateTriangleAreaMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = calculateTriangleArea(base, height);

        System.out.printf("Area = %.2f", area);
    }

    private static double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}
