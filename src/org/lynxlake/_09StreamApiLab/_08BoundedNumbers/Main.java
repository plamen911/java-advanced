// https://judge.softuni.bg/Contests/Practice/Index/465#7
package org.lynxlake._09StreamApiLab._08BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int lowerBound = Math.min(bounds[0], bounds[1]);
        int upperBound = Math.max(bounds[0], bounds[1]);

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
