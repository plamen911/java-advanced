package org.lynxlake.exams.javaFundamentalsExam19Feb2017._02Earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {
    private static LinkedList<Integer> maxWaveList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        maxWaveList = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        LinkedList[] list1 = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            list1[i] = numbers;
        }

        //while (true) {
        for(int i = 0; i < 200; i++) {
            boolean allOver = true;
            for (LinkedList aList1 : list1) {
                if (aList1.size() > 0) {
                    allOver = false;
                    break;
                }
            }
            if (allOver) {
                break;
            }

            for (LinkedList aList : list1) {
                reduceWaves(aList);
            }
        }

        System.out.println(maxWaveList.size());
        for (Integer integer : maxWaveList) {
            System.out.print(integer + " ");
        }
    }

    private static void reduceWaves(LinkedList<Integer> currentActivity) {
        if (currentActivity.size() == 0) return;

        int firstInteger = currentActivity.get(0);
        int indexEnd = 0;

        if (currentActivity.size() == 1) {
            maxWaveList.add(firstInteger);
            // currentActivity.subList(0, indexEnd + 1).clear();
            currentActivity.clear();
            return;
        }

        for (int i = 1; i < currentActivity.size(); i++) {
            if (firstInteger >= currentActivity.get(i)) {
                indexEnd = i;// removed from the activity
            } else {
                maxWaveList.add(firstInteger);

                System.out.println("should remove to idx " + (indexEnd + 1) + " / " + currentActivity);

                currentActivity.subList(0, indexEnd + 1).clear();
                return;
            }
        }
    }
}
