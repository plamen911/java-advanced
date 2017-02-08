package org.lynxlake._05FilesAndStreamsExercises._10SerializeArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH = PROJECT_PATH + "doubles.list";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 5.6, 45.6, 3.46);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(doubles);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        System.out.println(ois.readObject());
        ois.close();
    }
}
