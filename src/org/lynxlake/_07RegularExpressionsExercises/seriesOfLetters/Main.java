// https://judge.softuni.bg/Contests/Practice/Index/189#2
package org.lynxlake._07RegularExpressionsExercises.seriesOfLetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().trim();

        // String regexp = "([a-z])\\1*";
        String regexp = "(.)\\1*";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group(1));
        }
    }
}
