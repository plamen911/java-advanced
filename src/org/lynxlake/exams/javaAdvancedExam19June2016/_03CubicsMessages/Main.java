// https://judge.softuni.bg/Contests/Practice/Index/227#2
package org.lynxlake.exams.javaAdvancedExam19June2016._03CubicsMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"Over!".equals(line = reader.readLine())) {
            int messageLength = Integer.parseInt(reader.readLine());
            final String regex = "^([0-9]+)([A-Za-z]{" + messageLength + "})([^A-Za-z]*)$";

            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String digitsBefore = matcher.group(1);
                String message = matcher.group(2);
                String digitsAfter = matcher.group(3);

                System.out.print(message + " == " + getVerificationCode(digitsBefore, digitsAfter, message));
                System.out.println();
            }
        }
    }

    private static String getVerificationPart(String digitsBefore, String message) {
        String encodedPart = "";
        for (int i = 0; i < digitsBefore.length(); i++) {
            int index = digitsBefore.charAt(i) - '0';
            try {
                encodedPart += String.valueOf(message.charAt(index));
            } catch (StringIndexOutOfBoundsException ex) {
                encodedPart += " ";
            }
        }
        return encodedPart;
    }

    private static String getVerificationCode(String digitsBefore, String digitsAfter, String message) {
        return String.format("%s%s", getVerificationPart(digitsBefore, message), getVerificationPart(digitsAfter, message));
    }
}
