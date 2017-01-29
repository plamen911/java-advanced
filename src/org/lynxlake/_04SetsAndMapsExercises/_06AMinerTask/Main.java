// https://judge.softuni.bg/Contests/Practice/Index/188#5
package org.lynxlake._04SetsAndMapsExercises._06AMinerTask;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();
        while (true) {
            String resource = scanner.nextLine();
            if (resource.equalsIgnoreCase("stop")) {
                break;
            }
            long quantity = Long.parseLong(scanner.nextLine());
            if (!resources.containsKey(resource)) {
                resources.put(resource, 0L);
            }
            resources.put(resource, resources.get(resource) + quantity);
        }

        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
