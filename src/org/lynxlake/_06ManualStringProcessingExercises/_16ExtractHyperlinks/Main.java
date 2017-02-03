// https://judge.softuni.bg/Contests/Practice/Index/195#15
package org.lynxlake._06ManualStringProcessingExercises._16ExtractHyperlinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String pattern = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)|([^\\s>]+))[^>]*>";
        Pattern p = Pattern.compile(pattern);

        while (true) {
            String input = reader.readLine();
            if ("END".equals(input)) {
                break;
            }
            text.append(input);
        }

        Matcher m = p.matcher(text);
        while (m.find()) {
            for (int i = 5; i >= 1; i--) {
                if (m.group(i) != null) {
                    System.out.println(m.group(i));
                    break;
                }
            }
        }
    }
}
