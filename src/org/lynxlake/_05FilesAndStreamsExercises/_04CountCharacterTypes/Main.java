package org.lynxlake._05FilesAndStreamsExercises._04CountCharacterTypes;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH_IN = PROJECT_PATH + "countCharacterTypesIn.txt";
    private static final String FILE_PATH_OUT = PROJECT_PATH + "countCharacterTypesOut.txt";

    public static void main(String[] args) {
        HashSet<Character> punctuation = new HashSet<>();
        HashSet<Character> vowels = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_IN));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_OUT))) {

            int vowelCount = 0;
            int consonantCount = 0;
            int punctuationCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (ch != ' ') {
                        if (vowels.contains(ch)) {
                            vowelCount++;
                        } else if (punctuation.contains(ch)) {
                            punctuationCount++;
                        } else {
                            consonantCount++;
                        }
                    }
                }
            }

            writer.write(String.format("Vowels: %d%n", vowelCount));
            writer.write(String.format("Consonants: %d%n", consonantCount));
            writer.write(String.format("Punctuation: %d%n", punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
