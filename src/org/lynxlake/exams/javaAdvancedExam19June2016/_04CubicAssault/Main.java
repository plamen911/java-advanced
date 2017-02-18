// https://judge.softuni.bg/Contests/Practice/Index/227#3
package org.lynxlake.exams.javaAdvancedExam19June2016._04CubicAssault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, TreeMap<String, Long>> army = new TreeMap<>();
        String line;
        while (!"Count em all".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+->\\s+");
            String regionName = tokens[0];
            String meteorType = tokens[1];
            long count = Long.parseLong(tokens[2]);
            if (!army.containsKey(regionName)) {
                TreeMap<String, Long> types = new TreeMap<>();
                types.put("Red", 0L);
                types.put("Black", 0L);
                types.put("Green", 0L);
                army.put(regionName, types);
            }
            army.get(regionName).put(meteorType, army.get(regionName).get(meteorType) + count);

            if (army.get(regionName).get("Green") >= 1000000L) {
                long currentCount = army.get(regionName).get("Green");
                long reminder = currentCount % 1000000L;
                long newCount = (currentCount - reminder) / 1000000L;
                army.get(regionName).put("Red", army.get(regionName).get("Red") + newCount);
                army.get(regionName).put("Green", reminder);
            }
            if (army.get(regionName).get("Red") >= 1000000L) {
                long currentCount = army.get(regionName).get("Red");
                long reminder = currentCount % 1000000L;
                long newCount = (currentCount - reminder) / 1000000L;
                army.get(regionName).put("Black", army.get(regionName).get("Black") + newCount);
                army.get(regionName).put("Red", reminder);
            }
        }

        army.entrySet().stream()
                .sorted((a1, a2) -> {
                    long a1Black = a1.getValue().get("Black");
                    long a2Black = a2.getValue().get("Black");
                    if (a1Black == a2Black) {
                        return Integer.compare(a1.getKey().length(), a2.getKey().length());
                    }
                    return Long.compare(a2Black, a1Black);
                })
                .forEach(item -> {
                    System.out.println(item.getKey());
                    item.getValue().entrySet().stream()
                            .sorted((x1, x2) -> Long.compare(x2.getValue(), x1.getValue()))
                            .forEach(p -> {
                                System.out.printf("-> %s : %d%n", p.getKey(), p.getValue());
                            });
                });
    }
}
