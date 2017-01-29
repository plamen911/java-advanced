// https://judge.softuni.bg/Contests/Practice/Index/403#3
package org.lynxlake._05FilesAndStreamsLab._04ExtractIntegers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
