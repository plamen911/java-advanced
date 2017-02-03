// https://judge.softuni.bg/Contests/Practice/Index/458#6
package org.lynxlake._07RegularExpressionsLab._07ValidTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$");
        String text = reader.readLine();

        while (!text.equals("END")) {
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                if (isValidTime(matcher.group(0))){
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
            }

            text = reader.readLine();
        }
    }

    private static boolean isValidTime(String group) {
        String[] timeTokens = group.split(":");
        int seconds = Integer.parseInt(timeTokens[2].split(" ")[0]);
        int minutes = Integer.parseInt(timeTokens[1]);
        int hours = Integer.parseInt(timeTokens[0]);
        return seconds >= 0 && seconds < 60 && minutes >= 0 && minutes < 60 && hours > 0 && hours < 13;
    }
}
