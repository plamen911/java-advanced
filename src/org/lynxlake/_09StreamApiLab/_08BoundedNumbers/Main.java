// https://judge.softuni.bg/Contests/Practice/Index/465#7
package org.lynxlake._09StreamApiLab._08BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bounds = Stream.of(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int lowerBound = Math.min(bounds.get(0), bounds.get(1));
        int upperBound = Math.max(bounds.get(0), bounds.get(1));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(a -> !a.isEmpty())
                .map(Integer::valueOf)
                .filter(n -> lowerBound <= n && n <= upperBound)
                .collect(Collectors.toList());

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
