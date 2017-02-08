// https://judge.softuni.bg/Contests/Practice/Index/194#1
package org.lynxlake._08FunctionalProgrammingExercises._02KnightsOfHonor;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().trim().split("\\s+");
        Consumer<String> print = name -> System.out.printf("Sir %s%n", name);
        for (String name : names) {
            print.accept(name);
        }
    }
}
