// https://judge.softuni.bg/Contests/Practice/Index/194#9
package org.lynxlake._08FunctionalProgrammingExercises._10ListOfPredicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer range = Integer.parseInt(reader.readLine());
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            values.add(i);
        }

        ArrayList<Integer> divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        BiPredicate<Integer, ArrayList<Integer>> isDivisor = (number, arrayOfDivisors) -> {
            boolean areDivisors = true;
            for (Integer divisor : arrayOfDivisors) {
                if (number % divisor != 0) areDivisors = false;
            }

            return areDivisors;
        };

        values = values.stream().filter(a -> isDivisor.test(a, divisors))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Integer value : values) {
            System.out.print(value + " ");

        }
    }
}
