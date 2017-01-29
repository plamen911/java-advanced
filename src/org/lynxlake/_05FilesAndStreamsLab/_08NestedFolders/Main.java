// https://judge.softuni.bg/Contests/Practice/Index/403#7
package org.lynxlake._05FilesAndStreamsLab._08NestedFolders;

import java.io.File;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        String stringPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/Files-and-Streams";
        File file = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        int counter = 1;
        while (!queue.isEmpty()) {
            File currentDir = queue.poll();

            File[] nestedFiles = currentDir.listFiles();
            if (nestedFiles != null) {
                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isDirectory()) {
                        queue.offer(nestedFile);
                        counter++;
                    }
                }
            }

            System.out.println(currentDir.getName());
        }

        System.out.println(counter + " folders");
    }
}
