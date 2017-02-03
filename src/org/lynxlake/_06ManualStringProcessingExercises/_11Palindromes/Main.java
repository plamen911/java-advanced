// https://judge.softuni.bg/Contests/Practice/Index/195#10
package org.lynxlake._06ManualStringProcessingExercises._11Palindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Arrays.stream(reader.readLine().split("[\\s,\\.\\?\\!]"))
                .filter(item -> item != null && !"".equals(item))
                .collect(Collectors.toList());

        TreeSet<String> palindromes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (reversed.equals(word)) {
                palindromes.add(word);
            }
        }

        System.out.printf("[%s]%n", String.join(", ", palindromes));
    }
}
