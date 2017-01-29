// https://judge.softuni.bg/Contests/Practice/Index/187#7
package org.lynxlake.stacksAndQueuesExercises._09RecursiveFibonacci;

import java.util.Scanner;

public class Main {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // System.out.println(getFibonacci(n));

        memo = new long[n + 1];

        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = recursiveFibonacciWithMemoization(n - 1) + recursiveFibonacciWithMemoization(n - 2);

        return memo[n];
    }
}
