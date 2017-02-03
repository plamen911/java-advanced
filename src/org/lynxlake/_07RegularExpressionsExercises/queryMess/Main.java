// https://judge.softuni.bg/Contests/Practice/Index/189#8
package org.lynxlake._07RegularExpressionsExercises.queryMess;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String patternStr = "([^&=?]*)=([^&=]*)";
        String regexStr = "((%20|\\+)+)";

        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("END")) {
                break;
            }

            LinkedHashMap<String, ArrayList<String>> results = new LinkedHashMap<>();

            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String field = matcher.group(1)
                        .replaceAll(regexStr, " ")
                        .trim();

                String value = matcher.group(2)
                        .replaceAll(regexStr, " ")
                        .trim();

                if (!results.containsKey(field)) {
                    results.put(field, new ArrayList<>());
                }

                results.get(field).add(value);
            }

            for (Map.Entry<String, ArrayList<String>> entry : results.entrySet()) {
                System.out.printf("%s=[%s]", entry.getKey(), String.join(", ", entry.getValue()));
            }
            System.out.println();
        }
    }
}
