// https://judge.softuni.bg/Contests/Compete/Index/549#3
package org.lynxlake.exams.retakeExam03May2017._04FootballStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Plamen Markov on 5/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        Map<String, List<Game>> teamList = new HashMap<>();

        final String regex = "^(.*?)\\s-\\s+(.*?)\\sresult\\s(\\d):(\\d+)$";
        final Pattern pattern = Pattern.compile(regex);

        while (!"Season End".equals(line = reader.readLine())) {
            final Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String firstTeam = matcher.group(1);
                String secondTeam = matcher.group(2);
                int firstTeamGoals = Integer.parseInt(matcher.group(3));
                int secondTeamGoals = Integer.parseInt(matcher.group(4));

                Game firstTeamGame = new Game(firstTeam, secondTeam, firstTeamGoals, secondTeamGoals);
                Game secondTeamGame = new Game(secondTeam, firstTeam, secondTeamGoals, firstTeamGoals);

                teamList.putIfAbsent(firstTeam, new ArrayList<>());
                teamList.putIfAbsent(secondTeam, new ArrayList<>());

                teamList.get(firstTeam).add(firstTeamGame);
                teamList.get(secondTeam).add(secondTeamGame);
            }
        }

        String[] teamsToPrint = reader.readLine().trim().split(",\\s+");

        for (String teamName : teamsToPrint) {
            if (teamList.containsKey(teamName)) {
                List<Game> games = teamList.get(teamName);

                games.stream()
                        .sorted(Comparator.comparing(Game::getSecondTeam))
                        .forEach(game -> {
                            System.out.printf("%s - %s -> %d:%d%n",
                                    game.getFirstTeam(),
                                    game.getSecondTeam(),
                                    game.getFirstTeamGoals(),
                                    game.getSecondTeamGoals());
                        });
            }
        }
    }
}

class Game {
    private String firstTeam;
    private String secondTeam;
    private int firstTeamGoals;
    private int secondTeamGoals;

    public Game(String firstTeam, String secondTeam, int firstTeamGoals, int secondTeamGoals) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamGoals = firstTeamGoals;
        this.secondTeamGoals = secondTeamGoals;
    }

    public String getFirstTeam() {
        return this.firstTeam;
    }

    public String getSecondTeam() {
        return this.secondTeam;
    }

    public int getFirstTeamGoals() {
        return this.firstTeamGoals;
    }

    public int getSecondTeamGoals() {
        return this.secondTeamGoals;
    }
}
