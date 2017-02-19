// https://judge.softuni.bg/Contests/Compete/Index/471#1
package org.lynxlake.exams.javaFundamentalsExam19Feb2017._04Highscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Main {
    private static HashMap<String, LinkedList<String>> opponentNames;
    private static HashMap<String, LinkedList<Long>> opponentScores;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> players = new LinkedHashMap<>();

        opponentNames = new HashMap<>();
        opponentScores = new HashMap<>();

        String line;
        String[] pair;
        while (!"osu!".equals(line = reader.readLine().trim())) {
            pair = line.split("\\<\\-\\>");

            String[] tokens = pair[0].split("\\s+");
            long player1Score = Long.parseLong(tokens[0]);
            String player1Name = tokens[1];

            tokens = pair[1].split("\\s+");
            String player2Name = tokens[0];
            long player2Score = Long.parseLong(tokens[1]);

            Long diff;
            Long player1Points;
            Long player2Points;
            if (player1Score > player2Score) {
                diff = player1Score - player2Score;
                player1Points = diff;
                player2Points = diff * -1;
            } else {
                diff = player2Score - player1Score;
                player1Points = diff * -1;
                player2Points = diff;
            }

            addScore(players, player1Name, player2Name, player1Points);
            addScore(players, player2Name, player1Name, player2Points);
        }

        players.entrySet().stream()
                .sorted((a1, a2) -> {
                    Long sum1 = a1.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    Long sum2 = a2.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    return Long.compare(sum2, sum1);
                })
                .forEach(entry -> {
                    Long sum = entry.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    System.out.printf("%s - (%d)%n", entry.getKey(), sum);
                    if (opponentNames.containsKey(entry.getKey())) {
                        for (int i = 0; i < opponentNames.get(entry.getKey()).size(); i++) {
                            System.out.printf("*   %s <-> %d%n", opponentNames.get(entry.getKey()).get(i),
                                    opponentScores.get(entry.getKey()).get(i));
                        }
                    }
                });

    }

    private static void addScore(LinkedHashMap<String, LinkedHashMap<String, Long>> players, String player1Name, String player2Name, Long diff) {
        if (!players.containsKey(player1Name)) {
            players.put(player1Name, new LinkedHashMap<>());
        }
        if (!players.get(player1Name).containsKey(player2Name)) {
            players.get(player1Name).put(player2Name, 0L);
        }
        players.get(player1Name).put(player2Name, players.get(player1Name).get(player2Name) + diff);

        if (!opponentNames.containsKey(player1Name)) {
            opponentNames.put(player1Name, new LinkedList<>());
            opponentScores.put(player1Name, new LinkedList<>());
        }
        opponentNames.get(player1Name).add(player2Name);
        opponentScores.get(player1Name).add(diff);
    }
}
