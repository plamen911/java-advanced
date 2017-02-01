// https://judge.softuni.bg/Contests/Practice/Index/457#3
package org.lynxlake._06ManualStringProcessingLab._04SpecialWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] specialWords = reader.readLine().split("\\s+");
        String[] text = reader.readLine().split("\\s+");

        HashMap<String, Integer> result = new HashMap<>();
        for (String specialWord : specialWords) {
            for (String s : text) {
                if (specialWord.compareToIgnoreCase(s) == 0) {
                    if (!result.containsKey(specialWord)) {
                        result.put(specialWord, 0);
                    }
                    result.put(specialWord, result.get(specialWord) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
