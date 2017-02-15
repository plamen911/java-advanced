// https://judge.softuni.bg/Contests/Practice/Index/191#0
package org.lynxlake.exams.javaFundamentalsRetake08May2016._01Royalism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("\\s+");
        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalists = new ArrayList<>();
        for (String string : strings) {
            // sum the ASCII code values of all the characters
            int sum = 0;
            for (char ch : string.toCharArray()) {
                sum += (int)ch;
                while (sum > 26) {
                    sum -= 26;
                }
            }
            // 18 is the position of the letter 'R' in the English alphabet
            if (sum == 18) {
                royalists.add(string);
            } else {
                nonRoyalists.add(string);
            }
        }

        if (royalists.size() >= nonRoyalists.size()) {
            System.out.printf("Royalists - %d%n", royalists.size());
            for (String royalist : royalists) {
                System.out.printf("%s%n", royalist);
            }
            System.out.println("All hail Royal!");
        } else {
            for (String nonRoyalist : nonRoyalists) {
                System.out.printf("%s%n", nonRoyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
