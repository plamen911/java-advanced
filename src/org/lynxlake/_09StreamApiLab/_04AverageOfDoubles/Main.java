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
        try {
            OptionalDouble average = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average();

            if (average.isPresent()) {
                System.out.printf("%.2f", average.getAsDouble());
            } else {
                System.out.println("No match");
            }

        } catch (Exception ignored) {
            System.out.println("No match");
        }
    }
}
