// https://judge.softuni.bg/Contests/Practice/Index/465#1
package org.lynxlake._09StreamApiLab._02UpperStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toUpperCase)
                .forEach(b -> System.out.print(b + " "));
    }
}
