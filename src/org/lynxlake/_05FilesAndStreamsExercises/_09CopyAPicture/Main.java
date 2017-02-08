package org.lynxlake._05FilesAndStreamsExercises._09CopyAPicture;

import java.io.*;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH_IN = PROJECT_PATH + "picture.jpg";
    private static final String FILE_PATH_OUT = PROJECT_PATH + "picture-copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH_IN);
             FileOutputStream fos = new FileOutputStream(FILE_PATH_OUT)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                fos.write(oneByte);
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
