// https://judge.softuni.bg/Contests/Practice/Index/194#4
package org.lynxlake._08FunctionalProgrammingExercises._05AppliedArithmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        Function<String, Function<Integer, Integer>> checkInput = input -> {
            switch (input) {
                case "add":
                    return a -> a = a + 1;
                case "multiply":
                    return a -> a = a * 2;
                case "subtract":
                    return a -> a = a - 1;
                default:
                    return null;
            }
        };

        int[] numbers;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            while (true) {
                String input = reader.readLine();
                if (input.equals("end")) break;
                if (input.equals("print")) continue;

                if (checkInput.apply(input) != null) {
                    Function<Integer, Integer> action = checkInput.apply(input);

                    for (int i = 0; i < numbers.length; i++) {
                        int number = numbers[i];
                        numbers[i] = action.apply(number);
                    }
                }
            }

            Arrays.stream(numbers).forEach(a -> System.out.print(a + " "));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
