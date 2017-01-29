package org.lynxlake._05FilesAndStreamsExcercises._06WordCount;

import java.io.*;
import java.util.*;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String WORDS_FILE_PATH = PROJECT_PATH + "words.txt";
    private static final String TEXT_FILE_PATH = PROJECT_PATH + "text.txt";
    private static final String RESULTS_FILE_PATH = PROJECT_PATH + "results.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordsCount = new HashMap<>();
        Map<String, String> wordsOriginal = new HashMap<>();

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_FILE_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(RESULTS_FILE_PATH))) {

            String line;
            while ((line = wordsReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if (!wordsCount.containsKey(wordKey)) {
                        wordsCount.put(wordKey, 0);
                        wordsOriginal.put(wordKey, word);
                    }
                    wordsCount.put(wordKey, wordsCount.get(wordKey) + 1);
                }
            }

            wordsCount.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .forEach(word -> {
                        try {
                            writer.write(String.format("%s - %d%n", wordsOriginal.get(word.getKey()), word.getValue()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //System.out.printf("%s - %d%n", wordsOriginal.get(word.getKey()), word.getValue());
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
