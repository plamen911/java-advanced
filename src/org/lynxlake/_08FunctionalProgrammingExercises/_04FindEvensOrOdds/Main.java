// https://judge.softuni.bg/Contests/Practice/Index/194#3
package org.lynxlake._08FunctionalProgrammingExercises._04FindEvensOrOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int from = input[0];
        int to = input[1];
        String command = reader.readLine();

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        for (int i = from; i <= to; i++) {
            if ("odd".equals(command) && !isEven.test(i)) {
                System.out.print(i + " ");
            } else if ("even".equals(command) && isEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
