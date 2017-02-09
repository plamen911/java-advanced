// https://judge.softuni.bg/Contests/Practice/Index/194#10
package org.lynxlake._08FunctionalProgramingLab._11PredicateParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guestList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String[] commandLine = reader.readLine().split("\\s+");

        while (!"Party!".equals(commandLine[0])) {
            String command = commandLine[0];
            Predicate<String> validate = getPredicate(commandLine);

            if (validate != null) {
                switch (command) {
                    case "Remove":
                        guestList.removeIf(validate);
                        break;
                    case "Double":
                        List<String> temp = new ArrayList<>();
                        guestList.forEach(guest -> {
                            if (validate.test(guest)) {
                                temp.add(guest);
                            }
                            temp.add(guest);
                        });
                        guestList = temp;
                        break;
                }
            }

            commandLine = reader.readLine().split(" ");
        }

        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        System.out.println(String.join(", ", guestList) + " are going to the party!");

    }

    private static Predicate<String> getPredicate(String[] commandLine) {
        String command = commandLine[1];
        switch (command) {
            case "StartsWith":
                return x -> x.startsWith(commandLine[2]);
            case "EndsWith":
                return x -> x.endsWith(commandLine[2]);
            case "Length":
                return x -> x.length() == Integer.parseInt(commandLine[2]);
            default:
                return null;
        }
    }
}
