// https://judge.softuni.bg/Contests/Practice/Index/201#5
package org.lynxlake._09StreamApiExercises._06FilterStudentsByPhone;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(student -> student.getPhone().startsWith("02") || student.getPhone().startsWith("+3592"))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()));
    }
}
