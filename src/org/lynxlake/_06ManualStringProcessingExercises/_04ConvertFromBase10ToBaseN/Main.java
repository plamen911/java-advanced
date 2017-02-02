// https://judge.softuni.bg/Contests/Practice/Index/195#3
package org.lynxlake._06ManualStringProcessingExercises._04ConvertFromBase10ToBaseN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        BigInteger base10 = new BigInteger(numbers[1]);
        StringBuilder baseN = new StringBuilder();

        while (base10.compareTo(new BigInteger("0")) > 0) {
            BigInteger reminder = base10.divideAndRemainder(new BigInteger(n + ""))[1];
            BigInteger divide = base10.divideAndRemainder(new BigInteger(n + ""))[0];
            baseN.insert(0, reminder);
            base10 = divide;
        }

        System.out.println(baseN.toString());
    }
}
