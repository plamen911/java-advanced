// https://judge.softuni.bg/Contests/Practice/Index/403#5
package org.lynxlake.filesAndStreamsLab._06SortLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/filesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/filesAndStreamsLab/resources/output.txt";

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
