// https://judge.softuni.bg/Contests/Practice/Index/382#3
package org.lynxlake._01JavaSyntaxLab._04Greeting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        if (firstName == null || firstName.isEmpty()) {
            firstName = "*****";
        }
        if (secondName == null || secondName.isEmpty()) {
            secondName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, secondName);
    }
}
