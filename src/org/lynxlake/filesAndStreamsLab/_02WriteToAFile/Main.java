// https://judge.softuni.bg/Contests/Practice/Index/403#1
package org.lynxlake.filesAndStreamsLab._02WriteToAFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/org/lynxlake/filesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/filesAndStreamsLab/resources/output.txt";
        List<Character> punctuation = new ArrayList<>();
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('!');
        punctuation.add('?');

        try (FileInputStream fileStream = new FileInputStream(path)) {

            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.ISO_8859_1);
            Writer out = new BufferedWriter(outputStreamWriter);

            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    out.write(oneByte);
                }
                oneByte = fileStream.read();
            }

            out.close();
            fileStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
