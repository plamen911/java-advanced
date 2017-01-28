// https://judge.softuni.bg/Contests/Practice/Index/403#6
package org.lynxlake.filesAndStreamsLab._07ListFiles;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String stringPath = "src/org/lynxlake/filesAndStreamsLab/resources/Files-and-Streams";

        File file = new File(stringPath);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: %s%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
