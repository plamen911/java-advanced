// https://judge.softuni.bg/Contests/Practice/Index/403#0
package org.lynxlake._05FilesAndStreamsLab._01ReadFile;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src/org/lynxlake/_05FilesAndStreamsLab/resources/input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
