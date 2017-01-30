package org.lynxlake._03StacksAndQueuesExercises._14StockSpanProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(reader.readLine());
        }

        int[] result = calculateSpan(price);

        for (int val : result) {
            System.out.println(val);
        }
    }

    private static int[] calculateSpan(int stock[]) {
        int n = stock.length;
        int[] span = new int[n];

        // Span value of first day is always 1
        span[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {
            span[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (stock[i] >= stock[j]); j--) {
                span[i]++;
            }
        }

        return span;
    }
}
