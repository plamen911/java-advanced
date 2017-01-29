// https://judge.softuni.bg/Contests/Practice/Index/383#6
package org.lynxlake.javaSyntaxExercises._07OddAndEvenPairs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        if (numbers.length % 2 != 0) {
            System.out.printf("invalid length%n");

        } else {
            for (int i = 0; i < numbers.length; i += 2) {
                int num1 = Integer.parseInt(numbers[i]);
                int num2 = Integer.parseInt(numbers[i + 1]);

                if (num1 % 2 == 0 && num2 % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", num1, num2);
                } else if (num1 % 2 != 0 && num2 % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd%n", num1, num2);
                } else {
                    System.out.printf("%d, %d -> different%n", num1, num2);
                }
            }
        }
    }
}
