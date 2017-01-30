package org.lynxlake._03StacksAndQueuesExercises._14StockSpanProblem;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] result = calculateSpan(price);

        for (int val : result) {
            System.out.println(val);
        }
    }

    private static int[] calculateSpan(int stock[]) {
        int n = stock.length;
        int[] span = new int[n];

        // Create a stack and push index of first element to it
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        // Span value of first element is always 1
        span[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
                stack.pop();
            }

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
            // is greater than elements after top of stack
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push this element to stack
            stack.push(i);
        }

        return span;
    }
}
