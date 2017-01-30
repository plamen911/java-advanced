// https://judge.softuni.bg/Contests/Practice/Index/187#13
package org.lynxlake._03StacksAndQueuesExercises._14StockSpanProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Double> stack = new ArrayDeque<>();
        ArrayDeque<Double> temp = new ArrayDeque<>();
        int counter = 1;

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(reader.readLine());
            if (stack.isEmpty()) {
                stack.push(num);
                result.add(1);
            } else {
                if (num < stack.peek()) {
                    stack.push(num);
                    result.add(1);
                } else {
                    counter = 1;
                    temp.clear();
                    temp.addAll(stack);
                    while (!temp.isEmpty()) {
                        if (temp.pop() <= num) {
                            counter++;
                        } else {
                            break;
                        }
                    }
                    result.add(counter);
                    stack.push(num);
                }
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
