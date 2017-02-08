// https://judge.softuni.bg/Contests/Practice/Index/463#2
package org.lynxlake._08FunctionalProgramingLab._03CountUpperCaseWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");

        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (checkerUpperCase.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
