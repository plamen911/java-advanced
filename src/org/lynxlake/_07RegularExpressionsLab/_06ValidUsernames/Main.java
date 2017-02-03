// https://judge.softuni.bg/Contests/Practice/Index/458#5
package org.lynxlake._07RegularExpressionsLab._06ValidUsernames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");

        String text = reader.readLine();

        while (!"END".equals(text)) {
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            text = reader.readLine();
        }
    }
}
