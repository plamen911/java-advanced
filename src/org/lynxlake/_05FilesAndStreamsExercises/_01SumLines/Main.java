package org.lynxlake._05FilesAndStreamsExercises._01SumLines;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private final static String path = "/src/resources/someText.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        File someFile = new File(filePath);

        FileReader fileReader = new FileReader(someFile);

        // try with resources block
        /*try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                long sum = 0;
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
                System.out.println(sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Path pathIn = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(pathIn);
            for (String line : lines) {
                long sum = 0;
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
                System.out.println(sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
