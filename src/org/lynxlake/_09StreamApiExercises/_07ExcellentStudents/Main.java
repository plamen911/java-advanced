// https://judge.softuni.bg/Contests/Practice/Index/201#6
package org.lynxlake._09StreamApiExercises._07ExcellentStudents;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(student -> student.getGrades().stream().filter(g -> g == 6).count() > 0)
                .forEach(s -> {
                    System.out.printf("%s %s %s%n",
                            s.getFirstName(),
                            s.getLastName(),
                            String.join(" ", s.getGrades().stream()
                                    .sorted(Comparator.reverseOrder())
                                    .map(String::valueOf)
                                    .collect(Collectors.toList()))
                    );
                });

    }
}
