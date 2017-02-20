// https://judge.softuni.bg/Contests/Practice/Index/470#1
package org.lynxlake.exams.javaFundamentalsExam19Feb2017._02Earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main3 {
    private static LinkedList<Integer> maxWaveList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        maxWaveList = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        LinkedList<LinkedList<Integer>> activities = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            activities.add(numbers);
        }

        while (activities.size() > 0) {
            reduceValues(activities);
        }

        System.out.println(maxWaveList.size());
        for (Integer integer : maxWaveList) {
            System.out.print(integer + " ");
        }
    }

    private static void reduceValues(LinkedList<LinkedList<Integer>> activities) {
        LinkedList<LinkedList<Integer>> tmpList = new LinkedList<>();
        for (LinkedList<Integer> activity : activities) {
            if (activity.size() == 1) {
                maxWaveList.add(activity.get(0));
            } else if (activity.size() > 1) {
                int first = activity.get(0);
                LinkedList<Integer> tmp = new LinkedList<>();
                int i = 1;
                boolean hit = false;
                for (; i < activity.size(); i++) {
                    if (first < activity.get(i)) {
                        maxWaveList.add(first);
                        hit = true;
                        break;
                    }
                }
                if (hit) {
                    tmp.addAll(activity.subList(i, activity.size()));
                    tmpList.add(tmp);
                } else {
                    maxWaveList.add(first);
                }
            }
        }
        activities.clear();
        activities.addAll(tmpList);
    }
}
