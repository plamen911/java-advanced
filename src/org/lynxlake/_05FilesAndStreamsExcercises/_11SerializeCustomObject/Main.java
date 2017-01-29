package org.lynxlake._05FilesAndStreamsExcercises._11SerializeCustomObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH = PROJECT_PATH + "course.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 200;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(course);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Course newCourse = (Course)ois.readObject();
        System.out.println(newCourse);
        ois.close();
    }

    static class Course implements Serializable {
        String name;
        int numberOfStudents;

        @Override
        public String toString() {
            return String.format("%s %d", this.name, this.numberOfStudents);
        }
    }
}
