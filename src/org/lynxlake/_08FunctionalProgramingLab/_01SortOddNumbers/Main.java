// https://judge.softuni.bg/Contests/Practice/Index/463#0
package org.lynxlake._08FunctionalProgramingLab._01SortOddNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.asList(
                Arrays.stream(reader.readLine().split("\\s*,\\s*"))
                        .map(Integer::parseInt)
                        .filter(n -> n % 2 == 0)
                        .toArray(Integer[]::new)
        );

        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        if (sb.length() > 0) {
            String text = sb.toString().substring(0, sb.toString().length() - 2);
            System.out.println(text);
        }

        numbers.sort(Integer::compareTo);

        StringBuilder sb2 = new StringBuilder();
        for (Integer number : numbers) {
            sb2.append(number).append(", ");
        }

        if (sb2.length() > 0) {
            String text = sb2.toString().substring(0, sb2.toString().length() - 2);
            System.out.println(text);
        }
    }
}
