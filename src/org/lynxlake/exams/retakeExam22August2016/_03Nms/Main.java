// https://judge.softuni.bg/Contests/Practice/Index/276#2
package org.lynxlake.exams.retakeExam22August2016._03Nms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while (!"---NMS SEND---".equals(input = reader.readLine())) {
            sb.append(input);
        }
        String delimiter = reader.readLine();

        List<String> words = new ArrayList<>();
        String message = sb.toString();
        while (message.length() > 0) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < message.toCharArray().length; i++) {
                word.append(message.charAt(i));
                if (i + 1 >= message.toCharArray().length || message.toLowerCase().charAt(i) > message.toLowerCase().charAt(i + 1)) {
                    break;
                }
            }
            message = message.replaceFirst(word.toString(), "");
            words.add(word.toString());
        }

        System.out.printf("%s", String.join(delimiter, words));
    }
}
