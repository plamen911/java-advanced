// https://judge.softuni.bg/Contests/Practice/Index/189#0
package org.lynxlake._07RegularExpressionsExercises._01MatchFullName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        final Pattern pattern = Pattern.compile(regex);

        String input;
        while (!"end".equals(input = reader.readLine())) {
            final Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }
        }
    }
}
