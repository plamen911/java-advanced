package org.lynxlake._05FilesAndStreamsExcercises._05LineNumbers;

import java.io.*;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH_IN = PROJECT_PATH + "lineNumbersIn.txt";
    private static final String FILE_PATH_OUT = PROJECT_PATH + "lineNumbersOut.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_IN));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_OUT))) {

            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                writer.write(String.format("%d. %s%n", i, line));
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
