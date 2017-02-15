// https://judge.softuni.bg/Contests/Practice/Index/92#3
package org.lynxlake.advancedCSharpExam19July2015._04PopulationCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, HashMap<String, Long>> countries = new TreeMap<>();
        String line;
        while (!"report".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new HashMap<>());
            }
            if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, 0L);
            }
            countries.get(country).put(city, countries.get(country).get(city) + population);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    long sum1 = c1.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    long sum2 = c2.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    return Long.compare(sum2, sum1);
                })
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n",
                            country.getKey(),
                            country.getValue().values().stream().mapToLong(Long::longValue).sum());

                    country.getValue().entrySet().stream()
                            .sorted((a1, a2) -> Long.compare(a2.getValue(), a1.getValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}
