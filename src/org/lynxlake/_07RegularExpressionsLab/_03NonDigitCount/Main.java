// https://judge.softuni.bg/Contests/Practice/Index/458#2
package org.lynxlake._07RegularExpressionsLab._03NonDigitCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("[^0123456789]");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println("Non-digits: " + count);
    }
}
