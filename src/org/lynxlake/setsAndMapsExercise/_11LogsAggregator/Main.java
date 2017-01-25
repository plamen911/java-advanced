// https://judge.softuni.bg/Contests/Practice/Index/188#10
package org.lynxlake.setsAndMapsExercise._11LogsAggregator;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> userSessionDurations = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIpAddresses = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().trim().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!userSessionDurations.containsKey(user)) {
                userSessionDurations.put(user, 0);
                userIpAddresses.put(user, new TreeSet<>());
            }

            TreeSet<String> ipAddresses = userIpAddresses.get(user);
            ipAddresses.add(ip);

            userSessionDurations.put(user, userSessionDurations.get(user) + duration);
            userIpAddresses.put(user, ipAddresses);
        }

        for (Map.Entry<String, Integer> entry : userSessionDurations.entrySet()) {
            System.out.printf("%s: %d [%s]%n", entry.getKey(), entry.getValue(),
                    String.join(", ", userIpAddresses.get(entry.getKey())));
        }
    }
}
