// https://judge.softuni.bg/Contests/Practice/Index/465#4
package org.lynxlake._09StreamApiLab._05MinEvenNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            OptionalDouble min = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .filter(x -> x % 2 == 0)
                    .min();

            if (min.isPresent()) {
                System.out.printf("%.2f", min.getAsDouble());
            } else {
                System.out.println("No match");
            }

        } catch (Exception ex) {
            System.out.println("No match");
        }
    }
}
