// https://judge.softuni.bg/Contests/Practice/Index/195#0
package org.lynxlake._06ManualStringProcessingExercises._01ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
