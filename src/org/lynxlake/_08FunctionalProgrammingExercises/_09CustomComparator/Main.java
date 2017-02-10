// https://judge.softuni.bg/Contests/Practice/Index/194#8
package org.lynxlake._08FunctionalProgrammingExercises._09CustomComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Main::oddBeforeEven)
                .toArray(Integer[]::new);

        String[] result = Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ");
        System.out.println(String.join(" ", result));
    }

    private static int oddBeforeEven(int x, int y) {
        if (x % 2 == 0 && y % 2 != 0) {
            return -1;
        }

        if (x % 2 != 0 && y % 2 == 0) {
            return 1;
        }

        if (x % 2 == 0 && y % 2 == 0) {
            if (x < y) return -1;
            if (x == y) return 0;
            if (x > y) return 1;
        }

        if (x < y) return -1;
        if (x == y) return 0;
        if (x > y) return 1;

        return 0;
    }
}
