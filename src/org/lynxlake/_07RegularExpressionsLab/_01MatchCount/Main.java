// https://judge.softuni.bg/Contests/Practice/Index/458#0
package org.lynxlake._07RegularExpressionsLab._01MatchCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile(reader.readLine());
        Matcher matcher = pattern.matcher(reader.readLine());

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        System.out.println(count);
    }
}
