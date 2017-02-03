// https://judge.softuni.bg/Contests/Practice/Index/189#4
package org.lynxlake._07RegularExpressionsExercises.extractEmail;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // String regex = "([A-Za-z0-9][\\.\\-_]?[A-Za-z0-9]+[\\.\\-_]?[A-Za-z0-9]+@[A-Za-z][A-Za-z0-9]+[\\-\\.]?[A-Za-z0-9]+\\.[A-Za-z]{2,4}\\b)";
        String regex = "((?<=\\s)|^)([a-z0-9][a-z0-9\\-._]*[a-z0-9])@([a-z0-9][a-z0-9\\-]*[a-z0-9]\\.)+[a-z0-9]+";

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
