// https://judge.softuni.bg/Contests/Practice/Index/187#0
package org.lynxlake.stacksAndQueues._01ReverseNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = reader.readLine().trim().split("\\s+");
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int number = Integer.parseInt(nums[i]);
            numbers.add(number);
        }

        for (int i = 0; i < nums.length; i++) {
            int number = numbers.pop();
            System.out.printf("%d ", number);
        }
    }
}
