// https://judge.softuni.bg/Contests/Practice/Index/188#7
package org.lynxlake.setsAndMapsExercise._08HandsOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (true) {
            String input = reader.readLine().trim();
            if (input.equalsIgnoreCase("JOKER")) {
                break;
            }
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] hands = tokens[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            for (String hand : hands) {
                players.get(name).add(hand);
            }
        }

        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), getCardsTotalValue(entry.getValue()));
        }
    }

    private static int getCardsTotalValue(HashSet<String> cards) {
        HashMap<String, Integer> powerMap = new HashMap<>();
        powerMap.put("2", 2);
        powerMap.put("3", 3);
        powerMap.put("4", 4);
        powerMap.put("5", 5);
        powerMap.put("6", 6);
        powerMap.put("7", 7);
        powerMap.put("8", 8);
        powerMap.put("9", 9);
        powerMap.put("10", 10);
        powerMap.put("J", 11);
        powerMap.put("Q", 12);
        powerMap.put("K", 13);
        powerMap.put("A", 14);

        HashMap<String, Integer> suitMap = new HashMap<>();
        suitMap.put("S", 4);
        suitMap.put("H", 3);
        suitMap.put("D", 2);
        suitMap.put("C", 1);

        int total = 0;

        for (String card : cards) {
            String powerStr;
            String suitStr;
            if (card.length() == 2) {
                powerStr = Character.toString(card.charAt(0));
                suitStr = card.substring(1);
            } else {
                powerStr = card.substring(0, 2);
                suitStr = card.substring(2);
            }
            int power = powerMap.get(powerStr);
            int suit = suitMap.get(suitStr);

            total += power * suit;
        }

        return total;
    }
}
