// https://judge.softuni.bg/Contests/Practice/Index/195#2
package org.lynxlake._06ManualStringProcessingExercises._03FormattingNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        int a = Integer.parseInt(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Double.parseDouble(numbers[2]);

        String binaryA = Integer.toBinaryString(a);
        if (binaryA.length() < 10) {
            binaryA = (new String(new char[10 - binaryA.length()]).replace("\0", "0")) + binaryA;
        }
        if (binaryA.length() > 10) {
            binaryA = binaryA.substring(0, 10);
        }

        System.out.printf("|%-10s|%10s|%10.2f|%-10.3f|", Integer.toHexString(a).toUpperCase(), binaryA, b, c);
    }
}
