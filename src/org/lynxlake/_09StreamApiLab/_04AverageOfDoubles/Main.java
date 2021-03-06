// https://judge.softuni.bg/Contests/Practice/Index/465#3
package org.lynxlake._09StreamApiLab._04AverageOfDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble average = Arrays.stream(reader.readLine().split("\\s+"))
                // .filter(item -> item != null && !"".equals(item))
                .filter(item -> !item.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();

        if (average.isPresent()) {
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
