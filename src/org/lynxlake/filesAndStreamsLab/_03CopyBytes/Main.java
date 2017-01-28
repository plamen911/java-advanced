// https://judge.softuni.bg/Contests/Practice/Index/403#2
package org.lynxlake.filesAndStreamsLab._03CopyBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/org/lynxlake/filesAndStreamsLab/resources/input.txt";
        String outputPath = "src/org/lynxlake/filesAndStreamsLab/resources/output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {

                // if (oneByte == ' ' || oneByte == '\r') {
                if (oneByte == 10 || oneByte == 32) {
                    fos.write(oneByte);
                } else {
                    String decimal = String.valueOf(oneByte);
                    for (char c : decimal.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
