// https://judge.softuni.bg/Contests/Practice/Index/465#2
package org.lynxlake._09StreamApiLab._03FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        HashSet<String> letters = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));

        Optional<String> name = Optional.ofNullable(names.stream()
                .filter(a -> letters.contains((a.charAt(0) + "").toLowerCase()))
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse(null));

        System.out.println(name == null ? "No match" : name.orElse("No match"));
    }
}
