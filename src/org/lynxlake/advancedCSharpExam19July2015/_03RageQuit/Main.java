// https://judge.softuni.bg/Contests/Practice/Index/92#2
package org.lynxlake.advancedCSharpExam19July2015._03RageQuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String input = reader.readLine();

        final String regex = "([^0-9]{1,20})([0-9]+)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String string = matcher.group(1).toUpperCase();
            int repeatCount = Integer.parseInt(matcher.group(2));
            for (int i = 0; i < repeatCount; i++) {
                sb.append(string);
            }
        }

        List<Character> chars = sb.toString().chars().mapToObj(e->(char)e).collect(Collectors.toList());
        long count = chars.stream().distinct().count();

        System.out.printf("Unique symbols used: %d%n", count);
        System.out.printf("%s", sb.toString());
    }
}
