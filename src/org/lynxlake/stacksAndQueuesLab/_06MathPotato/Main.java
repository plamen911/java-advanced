// https://judge.softuni.bg/Contests/Practice/Index/386#5
package org.lynxlake.stacksAndQueuesLab._06MathPotato;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int digit) {
        boolean prime = true;

        if (digit < 2) {
            prime = false;
        }

        for (int i = 2; i <= Math.sqrt(digit); i++) {
            if (digit % i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
