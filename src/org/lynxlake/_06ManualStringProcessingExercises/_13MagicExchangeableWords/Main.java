// https://judge.softuni.bg/Contests/Practice/Index/195#12
package org.lynxlake._06ManualStringProcessingExercises._13MagicExchangeableWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        if (input[0].length() > input[1].length()) {
            System.out.println(exchangeableWords(input[1], input[0]));
        } else {
            System.out.println(exchangeableWords(input[0], input[1]));
        }
    }

    private static boolean exchangeableWords(String s, String s1) {
        HashMap<Character, Character> store = new HashMap<>();
        String word1 = "";
        String word2 = "";

        for (int i = 0; i < s.length(); i++) {
            if (!word1.contains(s.charAt(i) + "")) {
                word1 += s.charAt(i);
            }
            if (store.containsKey(s.charAt(i))) {
                if (store.get(s.charAt(i)) != s1.charAt(i)) {
                    return false;
                }
            } else {
                store.put(s.charAt(i), s1.charAt(i));
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            if (!word2.contains(s1.charAt(i) + "")) {
                word2 += s1.charAt(i);
            }
        }

        return word1.length() == word2.length();
    }
}
