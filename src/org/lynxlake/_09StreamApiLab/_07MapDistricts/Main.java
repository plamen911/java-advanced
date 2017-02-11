// https://judge.softuni.bg/Contests/Practice/Index/465#6
package org.lynxlake._09StreamApiLab._07MapDistricts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();
        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        for (String token : tokens) {
            String[] tokenArgs = token.split(":");
            String city = tokenArgs[0];
            int districtPopulation = Integer.parseInt(tokenArgs[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }

        int bound = Integer.parseInt(reader.readLine());

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(bound))
                .sorted(getSortByDescendingPopulationComparator())
                .forEach(getMapPrintEntryConsumer());

    }

    private static Predicate<Map.Entry<String, List<Integer>>> getFilterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= bound;
    }

    private static Comparator<Map.Entry<String, List<Integer>>> getSortByDescendingPopulationComparator() {
        return (kv1, kv2) -> {
            final int sum1 = kv1.getValue().stream().mapToInt(Integer::valueOf).sum();
            final int sum2 = kv2.getValue().stream().mapToInt(Integer::valueOf).sum();
            return Integer.compare(sum2, sum1);
        };
    }

    private static Consumer<Map.Entry<String, List<Integer>>> getMapPrintEntryConsumer() {
        return  kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(c -> System.out.print(c + " "));
            System.out.println();
        };
    }
}
