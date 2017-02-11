// https://judge.softuni.bg/Contests/Practice/Index/201#7
package org.lynxlake._09StreamApiExercises._08WeakStudents;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(s -> s.getGrades().stream().filter(g -> g <= 3).count() >= 2)
                .sorted((s1, s2) ->
                        Integer.compare(
                                s1.getGrades().stream().mapToInt(e -> e).sum(),
                                s2.getGrades().stream().mapToInt(e -> e).sum()
                        )
                )
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    // System.out.printf("%s%n", s.getGrades().stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
                    System.out.printf("%s%n", String.join(" ", s.getGrades().stream().sorted().map(String::valueOf).collect(Collectors.toList())));
                });

    }
}
