// https://judge.softuni.bg/Contests/Practice/Index/189#6
package org.lynxlake._07RegularExpressionsExercises._09ValidUsernames;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split("\\s+|/|\\\\|\\(|\\)");

        ArrayList<String> usernameList = new ArrayList<>();

        for (String username : usernames) {
            if (isValidUsername(username)) {
                usernameList.add(username);
            }
        }

        // Find 2 consecutive valid usernames with the biggest sum of their lengths
        int maxSum = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < usernameList.size() - 1; i++) {
            int theirSum = usernameList.get(i).length() + usernameList.get(i + 1).length();
            if (theirSum > maxSum) {
                maxSum = theirSum;
                maxIdx = i;
            }
        }

        System.out.println(usernameList.get(maxIdx));
        System.out.println(usernameList.get(maxIdx + 1));
    }

    private static boolean isValidUsername(String text) {
        String regex = "\\b[A-Za-z][A-Za-z0-9_]{3,25}\\b";
        return text.matches(regex);
    }
}
