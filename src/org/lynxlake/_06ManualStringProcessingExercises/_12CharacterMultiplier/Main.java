// https://judge.softuni.bg/Contests/Practice/Index/195#11
package org.lynxlake._06ManualStringProcessingExercises._12CharacterMultiplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        System.out.println(multiplyChars(input[0], input[1]));
    }

    private static int multiplyChars(String string1, String string2) {
        int sum = 0;

        for (int i = 0; i < Math.max(string1.length(), string2.length()); i++) {
             if (i < string1.length() && i < string2.length()) {
                 sum += string1.charAt(i) * string2.charAt(i);
             } else if (i < string1.length()) {
                 sum += string1.charAt(i);
             } else if (i < string2.length()) {
                 sum += string2.charAt(i);
             }
        }

        return sum;
    }
}
