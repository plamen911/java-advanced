// https://judge.softuni.bg/Contests/Practice/Index/276#0
package org.lynxlake.retakeExam22August2016._01SecondNature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
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

            if (bucket > flower) {
                flowers.remove(currentIdx);
                if (nextIdx >= buckets.size()) {
                    buckets.set(currentIdx, buckets.get(currentIdx) + bucket - flower);
                    break;
                }
                buckets.set(nextIdx, buckets.get(nextIdx) + bucket - flower);
                buckets.remove(currentIdx);

            } else if (bucket < flower) {
                buckets.remove(currentIdx);
                flowers.set(currentIdx, flower - bucket);

            } else {
                secondNature.add(flowers.get(currentIdx));
                flowers.remove(currentIdx);
                buckets.remove(currentIdx);
            }
        }

        if (buckets.size() > 0) {
            joinListOfIntegers(buckets);
        } else if (flowers.size() > 0) {
            joinListOfIntegers(flowers);
        } else {
            System.out.println("None");
        }

        if (secondNature.size() > 0) {
            joinListOfIntegers(secondNature);
        } else {
            System.out.println("None");
        }
    }

    private static void joinListOfIntegers(List<Integer> buckets) {
        System.out.printf("%s%n", String.join(" ", buckets.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
