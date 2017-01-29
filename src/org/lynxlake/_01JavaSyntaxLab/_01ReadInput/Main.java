// https://judge.softuni.bg/Contests/Practice/Index/382#0
package org.lynxlake._01JavaSyntaxLab._01ReadInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        String secondWord = scanner.next();
        Integer num1 = scanner.nextInt();
        Integer num2 = scanner.nextInt();
        Integer num3 = scanner.nextInt();
        String thirdWord = scanner.next();
        Integer sumOfNumbers = num1 + num2 + num3;
        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, sumOfNumbers);
    }
}
