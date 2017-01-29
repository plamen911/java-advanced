// https://judge.softuni.bg/Contests/Practice/Index/383#1
package org.lynxlake._01JavaSyntaxExercises._02TriangleArea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ax = scanner.nextLong();
        long ay = scanner.nextLong();
        long bx = scanner.nextLong();
        long by = scanner.nextLong();
        long cx = scanner.nextLong();
        long cy = scanner.nextLong();

        double area = Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);

        System.out.printf("%.0f", area);
    }
}
