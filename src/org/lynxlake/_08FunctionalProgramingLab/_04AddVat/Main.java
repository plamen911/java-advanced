// https://judge.softuni.bg/Contests/Practice/Index/463#3
package org.lynxlake._08FunctionalProgramingLab._04AddVat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(",\\s+");

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");

        for (String number : numbers) {
            System.out.println(String.format("%.2f", addVat.apply(Double.parseDouble(number))).replace(".", ","));
        }
    }
}
