// https://judge.softuni.bg/Contests/Practice/Index/91#0
package org.lynxlake.exams.advancedCSharpExam31May2015._01CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> result = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        result.removeAll(Arrays.asList("", null));

        String command = reader.readLine();
        while (!command.equals("end")) {
            try {
                executeCommand(command, result);
            } catch (Exception ex) {
                System.out.println("Invalid input parameters.");
            }
            command = reader.readLine();
        }

        System.out.println(result);
    }

    private static void executeCommand(String command, List<String> result) {
        String[] commandArgs = command.split(" ");
        switch (commandArgs[0]) {
            case "reverse":
                reverseAction(commandArgs, result);
                break;
            case "sort":
                sortAction(commandArgs, result);
                break;
            case "rollLeft":
                rollLeftAction(commandArgs, result);
                break;
            case "rollRight":
                rollRightAction(commandArgs, result);
                break;
        }
    }

    private static void rollRightAction(String[] commandArgs, List<String> result) {
        int count = Integer.parseInt(commandArgs[1]) % result.size();

        ArrayList<String> bullshit = new ArrayList<>();
        bullshit.addAll(result.subList(result.size() - count, result.size()));
        bullshit.addAll(result.subList(0, result.size() - count));
        result.clear();
        result.addAll(bullshit);
    }

    private static void rollLeftAction(String[] commandArgs, List<String> result) {
        int count = Integer.parseInt(commandArgs[1]) % result.size();

        ArrayList<String> bullshit = new ArrayList<>(result.subList(0, count));
        bullshit.addAll(0, result.subList(count, result.size()));
        result.clear();
        result.addAll(bullshit);
    }

    private static void sortAction(String[] commandArgs, List<String> result) {
        int startIndex = Integer.parseInt(commandArgs[2]);
        int count = Integer.parseInt(commandArgs[4]);

        if (startIndex == result.size()) {
            throw new UnsupportedOperationException();
        }

        List<String> remSort = new ArrayList<>();
        remSort.addAll(result.subList(startIndex, startIndex + count));
        result.removeAll(remSort);
        //remSort.sort((x, y) -> x.compareToIgnoreCase(y));
        Collections.sort(remSort, Collator.getInstance(Locale.ENGLISH));
        result.addAll(startIndex, remSort);
    }

    private static void reverseAction(String[] commandArgs, List<String> result) {
        int startIndex = Integer.parseInt(commandArgs[2]);
        int count = Integer.parseInt(commandArgs[4]);

        if (startIndex == result.size()) {
            throw new UnsupportedOperationException();
        }

        List<String> remList = new ArrayList<>();
        remList.addAll(result.subList(startIndex, startIndex + count));
        result.removeAll(remList);
        Collections.reverse(remList);
        result.addAll(startIndex, remList);
    }
}
