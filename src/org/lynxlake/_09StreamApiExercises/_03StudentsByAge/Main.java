// https://judge.softuni.bg/Contests/Practice/Index/201#2
package org.lynxlake._09StreamApiExercises._03StudentsByAge;

import org.lynxlake._09StreamApiExercises.Helper;
import org.lynxlake._09StreamApiExercises.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Helper.getStudents();

        students.stream()
                .filter(student -> 18 <= student.getAge() && student.getAge() <= 24)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));
    }
}
