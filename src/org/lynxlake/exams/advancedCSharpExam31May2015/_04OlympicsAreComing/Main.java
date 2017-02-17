// https://judge.softuni.bg/Contests/Practice/Index/91#3
package org.lynxlake.exams.advancedCSharpExam31May2015._04OlympicsAreComing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashMap<String, Integer>> countries = new LinkedHashMap<>();
        String line;
        while (!"report".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s*\\|\\s*");
            String athlete = String.join(" ",
                    Arrays.stream(tokens[0].split("\\s+"))
                            .map(String::trim)
                            .map(String::valueOf)
                            .collect(Collectors.toList()));

            String country = String.join(" ",
                    Arrays.stream(tokens[1].split("\\s+"))
                            .map(String::trim)
                            .map(String::valueOf)
                            .collect(Collectors.toList()));

            if (!countries.containsKey(country)) {
                countries.put(country, new HashMap<>());
            }
            if (!countries.get(country).containsKey(athlete)) {
                countries.get(country).put(athlete, 0);
            }
            countries.get(country).put(athlete, countries.get(country).get(athlete) + 1);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    final int sum1 = c1.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    final int sum2 = c2.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    return Integer.compare(sum2, sum1);
                })
                .forEach(c -> {
                    System.out.printf("%s (%d participants): %d wins%n", c.getKey(),
                            c.getValue().entrySet().size(),
                            c.getValue().values().stream().mapToInt(Integer::intValue).sum()
                    );
                });
    }
}
