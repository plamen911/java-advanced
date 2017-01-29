// https://judge.softuni.bg/Contests/Practice/Index/388#2
package org.lynxlake._04SetsAndMapsLab._03VoinaNumberGame;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers();
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers();

        for (int i = 0; i < 50; i++) {
            if (firstPlayer != null && secondPlayer != null) {
                if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                    break;
                }

                int firstNumber = firstPlayer.iterator().next();
                firstPlayer.remove(firstNumber);

                int secondNumber = secondPlayer.iterator().next();
                secondPlayer.remove(secondNumber);

                if (firstNumber > secondNumber) {
                    firstPlayer.add(firstNumber);
                    firstPlayer.add(secondNumber);
                } else if (secondNumber > firstNumber) {
                    secondPlayer.add(firstNumber);
                    secondPlayer.add(secondNumber);
                }
            }
        }

        if (firstPlayer != null && secondPlayer != null) {
            if (firstPlayer.size() > secondPlayer.size()) {
                System.out.println("First player win!");
            } else if (secondPlayer.size() > firstPlayer.size()) {
                System.out.println("Second player win!");
            } else {
                System.out.println("Draw!");
            }
        }
    }

    private static LinkedHashSet<Integer> getPlayerNumbers() {
        LinkedHashSet<Integer> reminder = new LinkedHashSet<>();
        String line = scanner.nextLine();
        String[] input = line.split("\\s+");

        for (String anInput : input) {
            reminder.add(Integer.parseInt(anInput));
        }

        return reminder;
    }
}
