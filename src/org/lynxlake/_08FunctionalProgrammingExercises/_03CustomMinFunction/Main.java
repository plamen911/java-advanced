// https://judge.softuni.bg/Contests/Practice/Index/194#2
package org.lynxlake._08FunctionalProgrammingExercises._03CustomMinFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> getMin = (x) -> {
            Arrays.sort(x);
            return x[0];
        };

        System.out.println(getMin.apply(numbers));
    }
}
