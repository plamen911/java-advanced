// https://judge.softuni.bg/Contests/Practice/Index/276#3
package org.lynxlake.exams.retakeExam22August2016._04AshesOfRoses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String regex = "^Grow <(?<regionName>[A-Z][a-z]+)> <(?<colorName>[A-Za-z0-9]+)> (?<roseAmount>[0-9]+)$";
        final Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Long>> desertRoses = new TreeMap<>();
        String input = "";

        while (!("Icarus, Ignite!".equals(input = reader.readLine()))) {
            final Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String regionName = matcher.group("regionName");
                String colorName = matcher.group("colorName");
                Long roseAmount = Long.parseLong(matcher.group("roseAmount"));

                if (!desertRoses.containsKey(regionName)) {
                    desertRoses.put(regionName, new HashMap<>());
                }
                if (!desertRoses.get(regionName).containsKey(colorName)) {
                    desertRoses.get(regionName).put(colorName, 0L);
                }
                desertRoses.get(regionName).put(colorName, desertRoses.get(regionName).get(colorName) + roseAmount);
            }
        }

        desertRoses.entrySet().stream().sorted((e1, e2) -> {
            long sum1 = e1.getValue().values().stream().mapToLong(Number::longValue).sum();
            long sum2 = e2.getValue().values().stream().mapToLong(Number::longValue).sum();
            return Long.compare(sum2, sum1);
        }).forEach(item -> {
            System.out.println(item.getKey());
            item.getValue().entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> {
                System.out.printf("*--%s | %d%n", e.getKey(), e.getValue());
            });
        });
    }
}
