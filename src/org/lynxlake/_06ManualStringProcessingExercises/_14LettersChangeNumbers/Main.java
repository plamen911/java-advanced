// https://judge.softuni.bg/Contests/Practice/Index/195#13
package org.lynxlake._06ManualStringProcessingExercises._14LettersChangeNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Double sum = 0.0;
        Character[] letters = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        List<Character> alphabet = Arrays.asList(letters);

        for (String anInput : input) {
            Character first = anInput.charAt(0);
            Character last = anInput.charAt(anInput.length() - 1);
            Double number = Double.parseDouble(anInput.substring(1, anInput.length() - 1));
            if (Character.isUpperCase(first)) {
                number = number / alphabet.indexOf(Character.toLowerCase(first));
            } else {
                number = number * alphabet.indexOf(Character.toLowerCase(first));
            }
            if (Character.isUpperCase(last)) {
                number = number - alphabet.indexOf(Character.toLowerCase(last));
            } else {
                number = number + alphabet.indexOf(Character.toLowerCase(last));
            }
            sum += number;
        }

        System.out.printf("%.2f", sum);
    }
}
