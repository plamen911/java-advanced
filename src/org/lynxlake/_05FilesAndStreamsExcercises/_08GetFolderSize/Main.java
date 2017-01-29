package org.lynxlake._05FilesAndStreamsExcercises._08GetFolderSize;

import java.io.File;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        String stringPath = "src/org/lynxlake/_05FilesAndStreamsLab/resources/Files-and-Streams";
        File file = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        long length = 0;
        while (!queue.isEmpty()) {
            File currentDir = queue.poll();

            File[] nestedFiles = currentDir.listFiles();
            if (nestedFiles != null) {
                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isFile()) {
                        queue.offer(nestedFile);
                        length += nestedFile.length();
                    }
                }
            }
        }

        System.out.printf("Folder size: %d%n", length);
    }
}
