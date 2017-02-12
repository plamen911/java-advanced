// https://judge.softuni.bg/Contests/Practice/Index/201#8
package org.lynxlake._09StreamApiExercises._09StudentsByEnrollmentYear;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.valueOf(s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2))
                ));

        studentsByYear.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(s -> {
                    System.out.println("20" + s.getKey() + ":");
                    s.getValue().stream()
                            .sorted(Comparator.comparing(a -> (a.getFirstName() + " " + a.getLastName())))
                            .forEach(n -> System.out.printf("-- %s %s%n", n.getFirstName(), n.getLastName()));
                });

    }
}
