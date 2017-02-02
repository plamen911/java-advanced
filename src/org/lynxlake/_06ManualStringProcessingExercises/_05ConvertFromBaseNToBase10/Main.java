// https://judge.softuni.bg/Contests/Practice/Index/195#4
package org.lynxlake._06ManualStringProcessingExercises._05ConvertFromBaseNToBase10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        if (Integer.parseInt(input[0]) == 10) {
            System.out.println(input[1]);
        } else {
            System.out.println(convertToBaseTen(new BigInteger(input[0]), new BigInteger(input[1])));
        }
    }

    private static String convertToBaseTen(BigInteger base, BigInteger number) {
        String num = number + "";
        BigInteger result = new BigInteger("0");
        result = result.add(new BigInteger(num.charAt(num.length() - 1) + ""));
        byte counter = 1;
        for (int i = num.length() - 2; i >= 0; i--) {
            BigInteger n = base;
            for (int j = 1; j < counter; j++) {
                n = n.multiply(base);
            }
            n = n.multiply(new BigInteger(num.charAt(i) + ""));
            result = result.add(new BigInteger((n + "")));
            counter++;
        }
        return result + "";
    }
}
