// https://judge.softuni.bg/Contests/Practice/Index/189#0
package org.lynxlake.regularExpressions.matchFullName;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            if (isFullName(input)) {
                System.out.println(input);
            }
        }
    }

    private static boolean isFullName(String str) {
        String regex = "[A-Z][a-z]+ [A-Z][a-z]+";
        return str.matches(regex);
    }
}
