// https://judge.softuni.bg/Contests/Practice/Index/188#3
package org.lynxlake.setsAndMaps.countSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = reader.readLine().toCharArray();
        SortedMap<Character, Integer> occurrences = new TreeMap<>();
        for (char letter : letters) {
            if (!occurrences.containsKey(letter)) {
                occurrences.put(letter, 0);
            }
            occurrences.put(letter, occurrences.get(letter) + 1);
        }

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
