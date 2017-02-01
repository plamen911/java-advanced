// https://judge.softuni.bg/Contests/Practice/Index/195#1
package org.lynxlake._06ManualStringProcessingExercises._02StringLength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int len = 20;

        StringBuilder sb = new StringBuilder(input);
        if (sb.toString().length() < len) {
            String s = "*";
            sb.append(new String(new char[len - input.length()]).replace("\0", s));
        }

        System.out.println(sb.toString().substring(0, len));
    }
}
