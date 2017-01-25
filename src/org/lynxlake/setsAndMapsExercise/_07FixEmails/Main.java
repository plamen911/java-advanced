// https://judge.softuni.bg/Contests/Practice/Index/188#6
package org.lynxlake.setsAndMapsExercise._07FixEmails;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> entries = new LinkedHashMap<>();
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("stop")) {
                break;
            }
            String email = scanner.nextLine();
            if (email.endsWith("us") || email.endsWith("uk")) {
                continue;
            }
            entries.put(name, email);
        }

        for (Map.Entry<String, String> entry : entries.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
