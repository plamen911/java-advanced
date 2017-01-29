// https://judge.softuni.bg/Contests/Practice/Index/403#1
package org.lynxlake._05FilesAndStreamsLab._02WriteToAFile;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/output.txt";

        HashSet<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
