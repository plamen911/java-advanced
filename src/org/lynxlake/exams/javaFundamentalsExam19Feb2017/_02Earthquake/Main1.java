package org.lynxlake.exams.javaFundamentalsExam19Feb2017._02Earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayList<ArrayList> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            list.add(numbers);
        }

        for (ArrayList arrayList : list) {

        }
    }

    private static ArrayList<Integer> reduceNumbers(ArrayList<Integer> numbers) {


        return numbers;
    }
}
