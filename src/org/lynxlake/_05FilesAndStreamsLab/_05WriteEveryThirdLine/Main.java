// https://judge.softuni.bg/Contests/Practice/Index/403#4
package org.lynxlake._05FilesAndStreamsLab._05WriteEveryThirdLine;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                if (counter% 3 == 0) {
                    writer.println(line);
                }
                line = reader.readLine();
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
