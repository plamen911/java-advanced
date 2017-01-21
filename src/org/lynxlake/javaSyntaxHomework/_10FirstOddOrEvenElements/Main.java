// https://judge.softuni.bg/Contests/Practice/Index/383#9
package org.lynxlake.javaSyntaxHomework._10FirstOddOrEvenElements;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        String[] commands = scanner.nextLine().split("\\s+");
        int numberOfElements = Integer.parseInt(commands[1]);
        int i = 0;
        for (String number : numbers) {
            if (numberOfElements <= i) {
                break;
            }
            int num = Integer.parseInt(number);
            if (commands[2].equalsIgnoreCase("odd") && num % 2 != 0) {
                System.out.printf("%d ", num);
                i++;
            } else if (commands[2].equalsIgnoreCase("even") && num % 2 == 0) {
                System.out.printf("%d ", num);
                i++;
            }
        }

        System.out.println();
    }
}
