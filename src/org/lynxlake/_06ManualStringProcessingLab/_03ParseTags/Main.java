// https://judge.softuni.bg/Contests/Practice/Index/457#2
package org.lynxlake._06ManualStringProcessingLab._03ParseTags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        while (true) {
            int startIndex = input.indexOf("<upcase>");
            int endIndex = input.indexOf("</upcase>");

            if (startIndex == -1 || endIndex == -1) {
                break;
            }

            String text = input.substring(startIndex + 8, endIndex);
            input = input.replace(String.format("<upcase>%s</upcase>", text), text.toUpperCase());
        }

        System.out.printf("%s%n", input);
    }
}
