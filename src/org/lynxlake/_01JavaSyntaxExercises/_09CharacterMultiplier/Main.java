// https://judge.softuni.bg/Contests/Practice/Index/383#8
package org.lynxlake._01JavaSyntaxExercises._09CharacterMultiplier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        String str1 = input[0];
        String str2 = input[1];
        int len = (str1.length() > str2.length()) ? str1.length() : str2.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (str1.length() - 1 >= i && str2.length() - 1 >= i) {
                int c1 = (int)str1.charAt(i);
                int c2 = (int)str2.charAt(i);
                sum += c1 * c2;
            } else if (str1.length() - 1 >= i) {
                sum += (int)str1.charAt(i);
            } else if (str2.length() - 1 >= i) {
                sum += (int)str2.charAt(i);
            }
        }

        System.out.printf("%d%n", sum);
    }
}
