// https://judge.softuni.bg/Contests/Practice/Index/403#0
package org.lynxlake.filesAndStreamsLab._01ReadFile;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src/org/lynxlake/filesAndStreamsLab/resources/input.txt";
        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte > 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
