// https://judge.softuni.bg/Contests/Practice/Index/188#2
package org.lynxlake.setsAndMapsExercises._03PeriodicTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();
        Long n = scanner.nextLong();
        scanner.nextLine();

        for (Long i = 0L; i < n; i++ ) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(input));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
