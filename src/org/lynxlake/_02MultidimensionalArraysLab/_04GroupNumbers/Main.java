// https://judge.softuni.bg/Contests/Practice/Index/381#3
package org.lynxlake._02MultidimensionalArraysLab._04GroupNumbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s*");

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(2, new ArrayList<>());

        for (String s : input) {
            int currentNumber = Integer.parseInt(s);
            matrix.get(Math.abs(currentNumber) % 3).add(currentNumber);
        }

        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }
}
