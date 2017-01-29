// https://judge.softuni.bg/Contests/Practice/Index/188#8
package org.lynxlake._04SetsAndMapsExercises._09UserLogs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens[0].equalsIgnoreCase("end")) {
                break;
            }
            String[] pairs = tokens[0].split("=");
            String ip = pairs[1];
            pairs = tokens[1].split("=");
            String message = pairs[1];
            pairs = tokens[2].split("=");
            String user = pairs[1];

            if (!logs.containsKey(user)) {
                logs.put(user, new LinkedHashMap<>());
            }
            if (!logs.get(user).containsKey(ip)) {
                logs.get(user).put(ip, 0);
            }
            logs.get(user).put(ip, logs.get(user).get(ip) + 1);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : logs.entrySet()) {
            System.out.printf("%s:%n", user.getKey());
            int len = user.getValue().size();
            int i = 0;
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                String separator = (len - 1) == i ? "." : ", ";
                System.out.printf("%s => %d%s", entry.getKey(), entry.getValue(), separator);
                i++;
            }
            System.out.println();
        }
    }
}
