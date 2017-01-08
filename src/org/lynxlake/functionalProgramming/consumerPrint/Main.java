// https://judge.softuni.bg/Contests/Practice/Index/194#0
package org.lynxlake.functionalProgramming.consumerPrint;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().trim().split("\\s+");
        Consumer<String> print = System.out::println;
        for (String name : names) {
            print.accept(name);
        }
    }
}
