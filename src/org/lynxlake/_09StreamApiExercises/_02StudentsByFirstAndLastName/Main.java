// https://judge.softuni.bg/Contests/Practice/Index/201#1
package org.lynxlake._09StreamApiExercises._02StudentsByFirstAndLastName;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(student -> student.getFirstName().compareTo(student.getLastName()) < 0)
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));

    }
}
