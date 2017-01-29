// https://judge.softuni.bg/Contests/Practice/Index/386#6
package org.lynxlake.stacksAndQueuesLab._07PalindromeChecker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palindromeCandidate = scanner.nextLine();

        Deque<Character> queue = new ArrayDeque<>();

        for (char c : palindromeCandidate.toCharArray()) {
            queue.offer(c);
        }

        boolean isPalindrome = true;

        while (queue.size() > 1) {
            char first = queue.poll();
            char last = queue.pollLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
