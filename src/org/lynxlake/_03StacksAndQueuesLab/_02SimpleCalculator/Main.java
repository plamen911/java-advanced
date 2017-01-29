// https://judge.softuni.bg/Contests/Practice/Index/386#1
package org.lynxlake._03StacksAndQueuesLab._02SimpleCalculator;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().trim().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
