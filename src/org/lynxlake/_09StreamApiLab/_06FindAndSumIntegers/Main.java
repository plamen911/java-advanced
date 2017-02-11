// https://judge.softuni.bg/Contests/Practice/Index/465#5
package org.lynxlake._09StreamApiLab._06FindAndSumIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalInt sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(a -> {
                    final String regex = "([0-9\\.-]+)";

                    final Pattern pattern = Pattern.compile(regex);
                    final Matcher matcher = pattern.matcher(a);

                    return matcher.find();
                })
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }
}
