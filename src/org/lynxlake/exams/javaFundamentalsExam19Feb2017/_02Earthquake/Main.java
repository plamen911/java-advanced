// https://judge.softuni.bg/Contests/Compete/Index/470#1
package org.lynxlake.exams.javaFundamentalsExam19Feb2017._02Earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedList<Integer> seismicitiesFound = new LinkedList<>();
        ArrayDeque<ArrayList> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            ArrayList numbers = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            queue.add(numbers);
        }

        while (queue.size() <= 1) {
            ArrayList<Integer> currentActivity = queue.getFirst();
            int firstWave = currentActivity.get(0);
            ArrayList<Integer> indexesToRemove = new ArrayList<>();
            for (int i = 1; i < currentActivity.size(); i++) {
                if (currentActivity.get(i) >= firstWave) {
                    currentActivity.remove(0);
                    for (int j = 0; j < indexesToRemove.size(); j++) {
                        currentActivity.remove(j);
                    }

                } else {
                    indexesToRemove.add(i);
                }
            }

        }

        String debug = "";




    }
}
