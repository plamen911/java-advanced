// https://judge.softuni.bg/Contests/Practice/Index/216#2
package org.lynxlake.exams.javaAdvancedSampleExam13June2016._03JediCodeX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lineCount; i++) {
            sb.append(reader.readLine());
        }

        String namePattern = reader.readLine();
        String nameRegex = String.format("%s(?<name>[a-zA-Z]{%d}(?!([a-zA-Z])))", namePattern, namePattern.length());
        Pattern namePat = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePat.matcher(sb.toString());

        String messagePattern = reader.readLine();
        String messageRegex = String.format("%s(?<message>[a-zA-Z0-9]{%d}(?![a-zA-Z0-9]))", messagePattern, messagePattern.length());
        Pattern messagePat = Pattern.compile(messageRegex);
        Matcher messageMatcher = messagePat.matcher(sb.toString());

        List<String> jediNames = new ArrayList<>();
        List<String> jediMessages = new ArrayList<>();

        while (nameMatcher.find()) {
            jediNames.add(nameMatcher.group("name"));
        }

        while (messageMatcher.find()) {
            jediMessages.add(messageMatcher.group("message"));
        }

        Integer[] messageIndex = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int currentJediIndex = 0;
        for (Integer aMessageIndex : messageIndex) {
            if (aMessageIndex - 1 < jediMessages.size() && currentJediIndex < jediNames.size()) {
                System.out.printf("%s - %s%n", jediNames.get(currentJediIndex), jediMessages.get(aMessageIndex - 1));
                currentJediIndex++;
            }
        }
    }
}
