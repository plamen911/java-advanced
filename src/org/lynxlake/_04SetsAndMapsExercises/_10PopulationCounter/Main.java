// https://judge.softuni.bg/Contests/Practice/Index/188#9
package org.lynxlake._04SetsAndMapsExercises._10PopulationCounter;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countriesAndCities = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesOnly = new LinkedHashMap<>();

        while (true) {
            String[] tokens = scanner.nextLine().trim().split("\\|");
            if (tokens[0].equalsIgnoreCase("report")) {
                break;
            }
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countriesAndCities.containsKey(country)) {
                countriesAndCities.put(country, new LinkedHashMap<>());
                countriesOnly.put(country, 0L);
            }
            if (!countriesAndCities.get(country).containsKey(city)) {
                countriesAndCities.get(country).put(city, 0L);
            }
            countriesAndCities.get(country).put(city, countriesAndCities.get(country).get(city) + population);
            countriesOnly.put(country, countriesOnly.get(country) + population);
        }

        countriesAndCities.entrySet().stream()
                .sorted((c1, c2) -> countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n", country.getKey(), countriesOnly.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> {
                                System.out.format("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}



