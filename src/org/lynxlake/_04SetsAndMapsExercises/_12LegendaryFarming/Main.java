// https://judge.softuni.bg/Contests/Practice/Index/188#11
package org.lynxlake._04SetsAndMapsExercises._12LegendaryFarming;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static final long WINNING_POINTS = 250L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Long> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0L);
        keyMaterials.put("fragments", 0L);
        keyMaterials.put("motes", 0L);

        TreeMap<String, Long> junkMaterials = new TreeMap<>();

        boolean keepLooping = true;

        while (keepLooping) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                long quantity = Long.parseLong(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equalsIgnoreCase("shards")
                        || material.equalsIgnoreCase("fragments")
                        || material.equalsIgnoreCase("motes")) {

                    if (!keyMaterials.containsKey(material)) {
                        keyMaterials.put(material, 0L);
                    }

                    // the first key material that reaches the 250 mark wins the race
                    long newQuantity = keyMaterials.get(material) + quantity;
                    if (newQuantity >= WINNING_POINTS) {
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }

                        keyMaterials.put(material, newQuantity - WINNING_POINTS);
                        keepLooping = false;
                        scanner.close();
                        break;

                    } else {
                        keyMaterials.put(material, newQuantity);
                    }

                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0L);
                    }
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((t1, t2) -> t1.getKey().compareTo(t2.getKey()))
                .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                /*.sorted((t1, t2) -> {
                    if (t1.getValue() >= t2.getValue()) {
                        return -1;
                    } else {
                        return 1;
                    }
                })*/
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                });

        for (Map.Entry<String, Long> entry : junkMaterials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}