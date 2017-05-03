// https://judge.softuni.bg/Contests/Compete/Index/549#1
package org.lynxlake.exams.retakeExam03May2017._02LetterExpresion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Plamen Markov on 5/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        final String regex = "([0-9\\.]+)([^0-9\\.]+)?";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);

        List<Double> numbers = new ArrayList<>();
        int op = 1;

        while (matcher.find()) {
            Double number = Double.parseDouble(matcher.group(1));
            number *= op;
            numbers.add(number);

            if (matcher.group(2) == null || matcher.group(2).length() % 2 == 0) {
                op = 1;
            } else {
                op = -1;
            }
        }

        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }

        DecimalFormat df = new DecimalFormat("###.#");
        System.out.println(df.format(sum));
    }
}
