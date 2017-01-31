// https://judge.softuni.bg/Contests/Practice/Index/457#0
package org.lynxlake._06ManualStringProcessingLab._01StudentsResults;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> results = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().trim().split(" - ");
            String name = input[0];
            results.put(name, new ArrayList<>());
            Arrays.stream(input[1].split(",\\s+")).map(Double::parseDouble).forEach(elem -> {
                results.get(name).add(elem);
            });
        }

        if (results.size() > 0) {
            // print table header
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

            // print table body
            for (Map.Entry<String, List<Double>> entry : results.entrySet()) {
                double firstResult = entry.getValue().get(0);
                double secondResult = entry.getValue().get(1);
                double thirdResult = entry.getValue().get(2);
                double average = (firstResult + secondResult + thirdResult) / 3;

                System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                        entry.getKey(),
                        decimalPoint2Comma(firstResult, 2),
                        decimalPoint2Comma(secondResult, 2),
                        decimalPoint2Comma(thirdResult, 2),
                        decimalPoint2Comma(average, 4)
                ));
            }
        }
    }

    private static String decimalPoint2Comma(double number, int precision) {
        return String.valueOf(String.format("%1$." + precision + "f", number)).replace('.', ',');
    }
}
