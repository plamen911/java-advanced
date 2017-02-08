// https://judge.softuni.bg/Contests/Practice/Index/463#1
package org.lynxlake._08FunctionalProgramingLab._02SumNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;
        for (String s : input) {
            sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
