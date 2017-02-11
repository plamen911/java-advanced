// https://judge.softuni.bg/Contests/Practice/Index/465#2
package org.lynxlake._09StreamApiLab._03FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        HashSet<Character> chars = new HashSet<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(a -> a.toLowerCase().charAt(0))
                .forEach(chars::add);

        Optional<String> firstName = names.stream()
                .filter(n -> chars.contains(n.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (firstName.isPresent()) {
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }
    }
}
