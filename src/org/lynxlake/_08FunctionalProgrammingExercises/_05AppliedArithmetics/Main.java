// https://judge.softuni.bg/Contests/Practice/Index/194#4
package org.lynxlake._08FunctionalProgrammingExercises._05AppliedArithmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = "";
        while (!(command = reader.readLine()).equals("end")) {
            switch (command) {
                case "add":
                    numberArray = Arrays.stream(numberArray).map(i -> i + 1).toArray();
                    break;
                case "subtract":
                    numberArray = Arrays.stream(numberArray).map(i -> i - 1).toArray();
                    break;
                case "multiply":
                    numberArray = Arrays.stream(numberArray).map(i -> i * 2).toArray();
                    break;
                case "print":
                    Arrays.stream(numberArray).forEach(i -> System.out.print(i + " "));
                    System.out.println();
                    break;
            }
        }
    }
}
