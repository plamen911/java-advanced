// https://judge.softuni.bg/Contests/Practice/Index/189#1
package org.lynxlake._07RegularExpressionsExercises.matchPhoneNumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "\\+359 2 [0-9]{3} [0-9]{4}|\\+359\\-2\\-[0-9]{3}\\-[0-9]{4}\\b";
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            sb.append(input);
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
