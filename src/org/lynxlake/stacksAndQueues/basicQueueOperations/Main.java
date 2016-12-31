// https://judge.softuni.bg/Contests/Practice/Index/187#3
package org.lynxlake.stacksAndQueues.basicQueueOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        Queue<Integer> myQueue = new ArrayDeque<>();
        String[] integers = reader.readLine().trim().split("\\s+");

        if (n != integers.length) {
            throw new IllegalArgumentException(";(");
        }

        // push onto the queue
        for (int i = 0; i < n; i++) {
            myQueue.add(Integer.parseInt(integers[i]));
        }

        // pop from the queue
        for (int i = 0; i < s; i++) {
            myQueue.remove();
        }

        // is x present in the queue
        if (myQueue.contains(x)) {
            System.out.println("true");
        } else if (myQueue.size() != 0) {
            int smallest = Integer.MAX_VALUE;
            for (Integer e : myQueue) {
                if (e < smallest) {
                    smallest = e;
                }
            }
            System.out.println(smallest);
        } else {
            System.out.println("0");
        }
    }
}
