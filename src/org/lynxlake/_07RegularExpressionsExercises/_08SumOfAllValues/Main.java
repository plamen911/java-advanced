// https://judge.softuni.bg/Contests/Practice/Index/189#7
package org.lynxlake._07RegularExpressionsExercises._08SumOfAllValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringKey = reader.readLine();
        String text = reader.readLine();
        String startKeyRegex = "^[a-zA-Z_]+(?=[0-9])";
        Pattern patternStartKey = Pattern.compile(startKeyRegex);
        Matcher matcherStartKey = patternStartKey.matcher(stringKey);
        String startKey = "";
        String endKeyRegex = "(?<=[0-9])[a-zA-Z_]+$";
        Pattern patternEndKey = Pattern.compile(endKeyRegex);
        Matcher matcherEndKey = patternEndKey.matcher(stringKey);
        String endKey = "";

        if (matcherStartKey.find() && matcherEndKey.find()) {
            startKey = matcherStartKey.group();
            endKey = matcherEndKey.group();
            String regex = startKey + "[0-9.]+?" + endKey;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            double result = 0.0;

            while (matcher.find()) {
                try {
                    double a = Double.parseDouble(matcher.group()
                            .substring(startKey.length(), matcher.group().length() - endKey.length()));
                    result += a;
                } catch (Exception ignored) {
                }
            }

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(result > 0 ? "<p>The total value is: <em>" + df.format(result) + "</em></p>" : "<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }
}
