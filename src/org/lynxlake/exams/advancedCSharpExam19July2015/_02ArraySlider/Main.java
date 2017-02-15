// https://judge.softuni.bg/Contests/Practice/Index/92#1
package org.lynxlake.exams.advancedCSharpExam19July2015._02ArraySlider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<BigInteger> listOfNumbers;
    private static int currentIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        input = input.replaceAll("\\s+", " ").trim();
        String[] array = input.split(" ");
        listOfNumbers = new ArrayList<>();
        for (String s : array) {
            listOfNumbers.add(new BigInteger(s));
        }

        String commandInput = reader.readLine();
        while (!commandInput.equals("stop")) {
            String[] command = commandInput.split(" ");
            int offset = Integer.parseInt(command[0]);
            BigInteger operand = new BigInteger(command[2]);
            String operation = command[1];

            findIndex(offset);
            BigInteger value = listOfNumbers.get(currentIndex);
            listOfNumbers.remove(currentIndex);
            manipulateValue(value, operand, operation);

            commandInput = reader.readLine();
        }

        System.out.println(listOfNumbers);
    }

    private static BigInteger valueChecker(BigInteger input) {
        if (input.compareTo(BigInteger.ZERO) < 0) {
            return BigInteger.ZERO;
        }
        return input;
    }

    private static void manipulateValue(BigInteger value, BigInteger operand, String operation) {
        switch (operation) {
            case "+":
                listOfNumbers.add(currentIndex, valueChecker(value.add(operand)));
                break;
            case "-":
                listOfNumbers.add(currentIndex, valueChecker(value.subtract(operand)));
                break;
            case "*":
                listOfNumbers.add(currentIndex, valueChecker(value.multiply(operand)));
                break;
            case "/":
                listOfNumbers.add(currentIndex, valueChecker(value.divide(operand)));
                break;
            case "&":
                listOfNumbers.add(currentIndex, valueChecker(value.and(operand)));
                break;
            case "|":
                listOfNumbers.add(currentIndex, valueChecker(value.or(operand)));
                break;
            case "^":
                listOfNumbers.add(currentIndex, valueChecker(value.xor(operand)));
                break;
            default:
        }
    }

    private static void findIndex(int offset) {
        offset = offset % listOfNumbers.size();
        if (listOfNumbers.size() == 1) {
            currentIndex = 0;
        } else {
            if (currentIndex + offset > listOfNumbers.size() - 1) {
                currentIndex = (currentIndex + offset) % (listOfNumbers.size());
            } else if (currentIndex + offset < 0) {
                currentIndex = listOfNumbers.size() + (currentIndex + offset);
            } else {
                currentIndex = currentIndex + offset;
            }
        }
    }
}
