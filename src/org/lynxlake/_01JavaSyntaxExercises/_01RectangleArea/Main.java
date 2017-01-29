// https://judge.softuni.bg/Contests/Practice/Index/383#0
package org.lynxlake._01JavaSyntaxExercises._01RectangleArea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String[] params = scanner.nextLine().split("\\s+");
//        long a = Long.parseLong(params[0]);
//        long b = Long.parseLong(params[1]);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double perimeter = a * b;
        System.out.printf("%.2f", perimeter);
    }
}
