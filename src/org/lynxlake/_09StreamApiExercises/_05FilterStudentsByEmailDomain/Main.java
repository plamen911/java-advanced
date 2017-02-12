// https://judge.softuni.bg/Contests/Practice/Index/201#4
package org.lynxlake._09StreamApiExercises._05FilterStudentsByEmailDomain;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(student -> student.getEmail().endsWith("@gmail.com"))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getEmail()));
    }
}
