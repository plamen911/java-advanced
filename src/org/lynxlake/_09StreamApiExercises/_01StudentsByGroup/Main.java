package org.lynxlake._09StreamApiExercises._01StudentsByGroup;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(a -> a.getGroup() == 2)
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }
}
