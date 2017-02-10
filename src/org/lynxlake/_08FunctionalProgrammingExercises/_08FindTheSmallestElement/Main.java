// https://judge.softuni.bg/Contests/Practice/Index/194#7
package org.lynxlake._08FunctionalProgrammingExercises._08FindTheSmallestElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> getSmallestIndex = arrayOfNumbers -> {
            int smallestValue = Integer.MAX_VALUE;
            int smallestIndex = 0;
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                Integer number = arrayOfNumbers[i];
                if (number <= smallestValue) {
                    smallestValue = number;
                    smallestIndex = i;
                }
            }
            return smallestIndex;
        };

        System.out.println(getSmallestIndex.apply(numbers));
    }
}
