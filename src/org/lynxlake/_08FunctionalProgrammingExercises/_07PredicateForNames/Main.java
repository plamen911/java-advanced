// https://judge.softuni.bg/Contests/Practice/Index/194#6
package org.lynxlake._08FunctionalProgrammingExercises._07PredicateForNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Function<String[], String[]> filterArray = arrayOfNames -> {
            List<String> result = new ArrayList<>();
            for (String name : arrayOfNames) {
                if (name.length() <= size) {
                    result.add(name);
                }
            }

            return result.toArray(new String[result.size()]);
        };

        Consumer<String[]> printer = a -> {
            for (String name : a) {
                System.out.println(name);
            }
        };

        names = filterArray.apply(names);
        printer.accept(names);
    }
}
