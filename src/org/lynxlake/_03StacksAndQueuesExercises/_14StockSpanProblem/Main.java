// https://judge.softuni.bg/Contests/Practice/Index/187#13
package org.lynxlake._03StacksAndQueuesExercises._14StockSpanProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int[] stock = new int[number];
        for (int i = 0; i < stock.length; i++) {
            stock[i] = Integer.parseInt(reader.readLine());
        }

        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        StringBuilder builder = new StringBuilder();
        builder.append(1).append("\n");
        for (int i = 1; i < number; i++) {
            while (!st.isEmpty() && stock[st.peek()] <= stock[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                builder.append(i - st.peek()).append("\n");
            } else {
                builder.append(i + 1).append("\n");
            }
            st.push(i);
        }

        System.out.println(builder.toString());
    }
}