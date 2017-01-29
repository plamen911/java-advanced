// https://judge.softuni.bg/Contests/Practice/Index/403#5
package org.lynxlake._05FilesAndStreamsLab._06SortLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/output.txt";

        Path pathIn = Paths.get(inputPath);
        Path pathOut = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(pathIn);
            // Collections.sort(lines);
            lines.sort(String::compareTo);

            Files.write(pathOut, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
