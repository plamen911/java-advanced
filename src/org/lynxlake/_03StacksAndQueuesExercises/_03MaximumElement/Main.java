// https://judge.softuni.bg/Contests/Practice/Index/187#2
package org.lynxlake._03StacksAndQueuesExercises._03MaximumElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            int command = Integer.parseInt(params[0]);

            switch (command) {
                case 1:
                    int numToPush = Integer.parseInt(params[1]);
                    stack.push(numToPush);
                    if (max <= numToPush) {
                        max = numToPush;
                        maxStack.push(max);
                    }
                    break;

                case 2:
                    int poppedItem = stack.pop();
                    if (poppedItem == max) {
                        maxStack.pop();
                        if (maxStack.size() > 0) {
                            max = maxStack.peek();
                        } else {
                            max = Integer.MIN_VALUE;
                        }
                    }
                    break;

                case 3:
                    System.out.println(max);
                    break;
            }
        }
    }
}
