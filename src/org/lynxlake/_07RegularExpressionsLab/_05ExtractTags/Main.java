// https://judge.softuni.bg/Contests/Practice/Index/458#4
package org.lynxlake._07RegularExpressionsLab._05ExtractTags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<.*?>");
        String text = reader.readLine();

        while (!"END".equals(text)) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            text = reader.readLine();
        }
    }
}
