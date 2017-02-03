// https://judge.softuni.bg/Contests/Practice/Index/189#5
package org.lynxlake._07RegularExpressionsExercises._06SentenceExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyword = reader.readLine().trim();
        String text = reader.readLine().trim();

        // String regexp = "[^!?.]+[!?.]";
        // [^!?.]+\bis\b[^!?.]+[!?.]
        String regexp = "[^!?.]*" + "\\b" + keyword + "\\b" + "[^!?.]*[!?.]";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
