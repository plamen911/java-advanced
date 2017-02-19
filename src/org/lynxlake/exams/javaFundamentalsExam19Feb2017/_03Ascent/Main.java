// https://judge.softuni.bg/Contests/Compete/Index/471#0
package org.lynxlake.exams.javaFundamentalsExam19Feb2017._03Ascent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> foundPatterns = new LinkedHashMap<>();

        String line;
        while (!"Ascend".equals(line = reader.readLine())) {
            line = getString(foundPatterns, line);
            System.out.println(line);
        }
    }

    private static String getString(HashMap<String, String> foundPatterns, String line) {
        for (String s : foundPatterns.keySet()) {
            line = line.replaceAll(s, foundPatterns.get(s));
        }

        final String regex = "(_|,)([A-Z-a-z]+)(\\d)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String message = matcher.group(2);
            int digit = Integer.parseInt(matcher.group(3));
            String op = matcher.group(1);
            String encodedString = op + message + digit;

            char[] chars = message.toCharArray();
            StringBuilder sb = new StringBuilder();
            if (op.equals(",")) {
                for (char aChar : chars) {
                    char ch = (char) (aChar + digit);
                    sb.append(ch);
                }
            } else {
                for (char aChar : chars) {
                    char ch = (char) (aChar - digit);
                    sb.append(ch);
                }
            }

            String decodedString = sb.toString();
            line = line.replaceAll(encodedString, decodedString);

            foundPatterns.put(encodedString, decodedString);
        }

        return line;
    }
}
