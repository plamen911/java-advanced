package org.lynxlake._05FilesAndStreamsExcercises._02SumBytes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH = PROJECT_PATH + "sumBytes.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            long sum = 0;
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
