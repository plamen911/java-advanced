// https://judge.softuni.bg/Contests/Practice/Index/195#8
package org.lynxlake._06ManualStringProcessingExercises._09TextFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (String word : bannedWords) {
            text = text.replace(word, new String(new char[word.length()]).replace("\0", "*"));
        }

        System.out.println(text);
    }
}
