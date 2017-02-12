// https://judge.softuni.bg/Contests/Practice/Index/201#3
package org.lynxlake._09StreamApiExercises._04SortStudents;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .sorted(getStudentComparator())
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }

    private static Comparator<Student> getStudentComparator() {
        return (s1, s2) -> {
            if (s1.getLastName().compareTo(s2.getLastName()) == 0) {
                return s2.getFirstName().compareTo(s1.getFirstName());
            }
            return s1.getLastName().compareTo(s2.getLastName());
        };
    }
}
