// https://judge.softuni.bg/Contests/Practice/Index/465#7
package org.lynxlake._09StreamApiLab._08BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int lowerBound = Math.min(bounds[0], bounds[1]);
        int upperBound = Math.max(bounds[0], bounds[1]);

        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(a -> !a.isEmpty())
                .mapToInt(Integer::valueOf)
                .filter(n -> lowerBound <= n && n <= upperBound)
                .forEach(e -> System.out.print(e + " "));
    }
}
