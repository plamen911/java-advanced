// https://judge.softuni.bg/Contests/Practice/Index/188#4
package org.lynxlake.setsAndMaps.phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phonebook = new HashMap<>();
        String input = reader.readLine().trim();
        while (!input.equalsIgnoreCase("search")) {
            String[] params = input.split("-");
            String name = params[0];
            String phone = params[1];
            phonebook.put(name, phone);
            input = reader.readLine().trim();
        }

        input = reader.readLine().trim();
        while (!input.equalsIgnoreCase("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = reader.readLine().trim();
        }
    }
}
