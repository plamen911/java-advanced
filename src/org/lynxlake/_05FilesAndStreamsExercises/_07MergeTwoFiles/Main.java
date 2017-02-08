package org.lynxlake._05FilesAndStreamsExercises._07MergeTwoFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH1_IN = PROJECT_PATH + "mergeTwoFiles1In.txt";
    private static final String FILE_PATH2_IN = PROJECT_PATH + "mergeTwoFiles2In.txt";
    private static final String FILE_PATH_OUT = PROJECT_PATH + "mergeTwoFilesOut.txt";

    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(FILE_PATH1_IN));
             BufferedReader reader2 = new BufferedReader(new FileReader(FILE_PATH2_IN));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_OUT))) {

            String line;
            List<String> textLines = new ArrayList<>();
            while ((line = reader1.readLine()) != null) {
                textLines.add(line);
            }
            while ((line = reader2.readLine()) != null) {
                textLines.add(line);
            }

            for (String text : textLines) {
                writer.write(String.format("%s%n", text));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
