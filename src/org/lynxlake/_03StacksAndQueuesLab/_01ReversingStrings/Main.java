// https://judge.softuni.bg/Contests/Practice/Index/386#0
package org.lynxlake._03StacksAndQueuesLab._01ReversingStrings;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();
        for (Character ch : inputString.toCharArray()) {
            reversed.push(ch);
        }

        while (!reversed.isEmpty()) {
            System.out.print(reversed.pop());
        }
    }
}
