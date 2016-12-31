// https://judge.softuni.bg/Contests/Practice/Index/187#1
package org.lynxlake.stacksAndQueues.basicStackOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        Stack<Integer> myStack = new Stack<>();
        String[] integers = reader.readLine().trim().split("\\s+");

        if (n != integers.length) {
            throw new IllegalArgumentException(";(");
        }

        // push onto the stack
        for (int i = 0; i < n; i++) {
            myStack.add(Integer.parseInt(integers[i]));
        }

        // pop from the stack
        for (int i = 0; i < s; i++) {
            int current = myStack.pop();
        }

        // is x present in the stack
        if (myStack.search(x) != -1) {
            System.out.println("true");
        } else if (!myStack.empty()) {
            // print smallest element
            Collections.sort(myStack);
            System.out.println(myStack.firstElement());
        } else {
            System.out.println("0");
        }
    }
}
