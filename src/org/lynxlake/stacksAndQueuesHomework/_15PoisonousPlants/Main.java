// https://judge.softuni.bg/Contests/Practice/Index/187#14
package org.lynxlake.stacksAndQueuesHomework._15PoisonousPlants;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int[] days = new int[n];
        int[] minElement = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (plants[i] < min) {
                min = plants[i];
            }
            minElement[i] = min;
        }

        int max = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (plants[i] > plants[i - 1]) {
                days[i] = 1;
                if (days[i] >= max) {
                    maxIndex = i;
                    max = days[i];
                }
                continue;
            }

            if (plants[i] > minElement[i]) {
                if (plants[i] > plants[maxIndex]) {
                    days[i] = days[i - 1] + 1;
                } else {
                    days[i] = days[maxIndex] + 1;
                }
            }
            if (plants[i] == minElement[i]) {
                max = 0;
            }

            if (days[i] >= max) {
                maxIndex = i;
                max = days[i];
            }
        }

        Arrays.sort(days);
        System.out.println(days[days.length - 1]);
    }
}
