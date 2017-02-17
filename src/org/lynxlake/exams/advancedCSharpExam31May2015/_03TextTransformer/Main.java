// https://judge.softuni.bg/Contests/Practice/Index/91#2
package org.lynxlake.exams.advancedCSharpExam31May2015._03TextTransformer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while (!"burp".equals(line = reader.readLine())) {
            sb.append(line);
        }
        final Pattern pattern = Pattern.compile("\\s+");
        final Matcher matcher = pattern.matcher(sb.toString());
        String result = matcher.replaceAll(" ");

        Pattern regex = Pattern.compile("(\\$|&|'|%)([^$&'%]+?)(\\1)");
        Matcher matcher1 = regex.matcher(result);

        sb = new StringBuilder();
        while (matcher1.find()) {
            switch (matcher1.group(1)) {
                case "$":
                    sb.append(stringManipulate(matcher1.group(2), 1)).append(" ");
                    break;
                case "%":
                    sb.append(stringManipulate(matcher1.group(2), 2)).append(" ");
                    break;
                case "&":
                    sb.append(stringManipulate(matcher1.group(2), 3)).append(" ");
                    break;
                case "'":
                    sb.append(stringManipulate(matcher1.group(2), 4)).append(" ");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static String stringManipulate(String reminder, int weight) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reminder.length(); i++) {
            char c = reminder.charAt(i);
            if (i % 2 == 0) {
                c += weight;
            } else {
                c -= weight;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
