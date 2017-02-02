// https://judge.softuni.bg/Contests/Practice/Index/195#5
package org.lynxlake._06ManualStringProcessingExercises._06CountSubstringOccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String search = reader.readLine();
        int occurrences = 0;

        for (int i = 0; i <= text.length() - search.length(); i++) {
            if (text.substring(i, i + search.length()).equalsIgnoreCase(search)) {
                occurrences++;
            }
        }

        System.out.println(occurrences);
    }
}
