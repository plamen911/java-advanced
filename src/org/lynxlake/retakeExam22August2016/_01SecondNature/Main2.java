// https://judge.softuni.bg/Contests/Practice/Index/276#0
package org.lynxlake.retakeExam22August2016._01SecondNature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> flowers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> buckets = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(buckets);

        List<Integer> secondNature = new LinkedList<>();

        while (flowers.size() > 0 && buckets.size() > 0) {
            int currentIdx = 0;
            int nextIdx = currentIdx + 1;
            int flower = flowers.get(currentIdx);
            int bucket = buckets.get(currentIdx);
            int remainingWater = bucket - flower;

            if (remainingWater > 0) {
                flowers.remove(currentIdx);
                if (nextIdx >= buckets.size()) {
                    buckets.set(currentIdx, remainingWater);
                    break;
                }
                buckets.set(nextIdx, buckets.get(nextIdx) + remainingWater);
            } else if (remainingWater < 0) {
                flowers.set(currentIdx, remainingWater * -1);
            } else {
                secondNature.add(flowers.get(currentIdx));
                flowers.remove(currentIdx);
            }

            buckets.remove(currentIdx);
        }

        if (buckets.size() > 0) {
            printListOfIntegers(buckets);
        } else if (flowers.size() > 0) {
            printListOfIntegers(flowers);
        }

        if (secondNature.size() > 0) {
            printListOfIntegers(secondNature);
        } else {
            System.out.println("None");
        }
    }

    private static void printListOfIntegers(List<Integer> buckets) {
        System.out.printf("%s%n", String.join(" ", buckets.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
