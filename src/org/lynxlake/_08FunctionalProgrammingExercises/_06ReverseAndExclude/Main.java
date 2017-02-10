// https://judge.softuni.bg/Contests/Practice/Index/194#5
package org.lynxlake._08FunctionalProgrammingExercises._06ReverseAndExclude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Integer n = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> isDivisibleByN = (a, number) -> a % number == 0;
        Consumer<ArrayList<Integer>> printer = (array) -> array.forEach(a -> System.out.print(a + " "));

        numbers = numbers.stream().filter(a -> !isDivisibleByN.test(a, n))
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.reverse(numbers);
        printer.accept(numbers);
    }
}
