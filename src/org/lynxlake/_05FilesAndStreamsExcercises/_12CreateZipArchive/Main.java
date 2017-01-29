package org.lynxlake._05FilesAndStreamsExcercises._12CreateZipArchive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH1_IN = PROJECT_PATH + "allCapitalsIn.txt";
    private static final String FILE_PATH2_IN = PROJECT_PATH + "allCapitalsOut.txt";
    private static final String FILE_PATH3_IN = PROJECT_PATH + "lineNumbersIn.txt";
    private static final String FILE_PATH_OUT = PROJECT_PATH + "text-files.zip";

    public static void main(String[] args) {

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(FILE_PATH_OUT));
             FileInputStream fis1 = new FileInputStream(FILE_PATH1_IN);
             FileInputStream fis2 = new FileInputStream(FILE_PATH2_IN);
             FileInputStream fis3 = new FileInputStream(FILE_PATH3_IN)) {

            int oneByte;

            zos.putNextEntry(new ZipEntry("allCapitalsIn.txt"));
            while ((oneByte = fis1.read()) != -1) {
                zos.write(oneByte);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("allCapitalsOut.txt"));
            while ((oneByte = fis2.read()) != -1) {
                zos.write(oneByte);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("lineNumbersIn.txt"));
            while ((oneByte = fis3.read()) != -1) {
                zos.write(oneByte);
            }
            zos.closeEntry();
            zos.finish();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
