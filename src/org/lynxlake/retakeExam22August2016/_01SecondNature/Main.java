// https://judge.softuni.bg/Contests/Practice/Index/276#0
package org.lynxlake.retakeExam22August2016._01SecondNature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> flowers = new ArrayList<>();
        ArrayList<Integer> buckets = new ArrayList<>();
        String[] input = reader.readLine().trim().split("\\s+"); // flowers, and the Weiss dust in them
        for (String anInput1 : input) {
            flowers.add(Integer.parseInt(anInput1));
        }
        input = reader.readLine().trim().split("\\s+"); // buckets with water
        for (String anInput : input) {
            buckets.add(Integer.parseInt(anInput));
        }

        int i = buckets.size() - 1;
        for (Integer flower : flowers) {
            int rest = buckets.get(i) - flower;
            System.out.println(rest + " = " + buckets.get(i) + " - " + flower);
            i--;
            buckets.set(i, buckets.get(i) + rest);
        }

        buckets.forEach(System.out::println);

    }
}
