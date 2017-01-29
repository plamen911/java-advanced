// https://judge.softuni.bg/Contests/Practice/Index/187#13
package org.lynxlake._03StacksAndQueuesExercises._14StockSpanProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Double> stack = new ArrayDeque<>();
        ArrayDeque<Double> temp = new ArrayDeque<>();
        int counter = 1;

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
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
