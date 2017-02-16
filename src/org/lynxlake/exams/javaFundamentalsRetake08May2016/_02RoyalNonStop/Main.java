// https://judge.softuni.bg/Contests/Practice/Index/191#1
package org.lynxlake.exams.javaFundamentalsRetake08May2016._02RoyalNonStop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] dimensions = parseArgsToInteger(scanner.nextLine().split(" "));

        Double[] productPrices = parseArgsToDouble(scanner.nextLine().split(" "));

        //BIGDECIMAL USE, WHY ? BECAUSE ACCORDING TO THE CONSTRAINTS, THE WORST CASE IS 2^64 * 10000 * 10000 WHICH IS ALOT
        //AND IT CAN BE DONE MANY TIMES
        BigDecimal totalMoney = BigDecimal.ZERO;
        Integer totalCustomers = 0;

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Royal Close")) {
            BigDecimal currentSum = BigDecimal.ZERO;

            Integer[] customerArguments = parseArgsToInteger(inputLine.split(" "));
            Integer initialRow = customerArguments[0];
            Integer initialColumn = customerArguments[1];

            if (initialRow >= initialColumn) {
                for (Integer currentColumn = initialColumn; currentColumn >= 0; currentColumn--) {
                    BigDecimal rowValue = new BigDecimal(initialRow + 1);
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);

                    BigDecimal productPrice = new BigDecimal(productPrices[initialRow % 2]);

                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }

                for (Integer currentRow = initialRow - 1; currentRow > 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);

                    BigDecimal productSum = rowValue.multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }
            } else {
                for (Integer currentRow = initialRow; currentRow >= 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal colValue = new BigDecimal(initialColumn + 1);

                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);

                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }

                for (Integer currentColumn = initialColumn - 1; currentColumn > 0; currentColumn--) {
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[0]);
                    BigDecimal productSum = colValue.multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
            }

            totalMoney = totalMoney.add(currentSum);
            totalCustomers++;

            inputLine = scanner.nextLine();
        }

        //PRINTING THE TOTAL MONEY ROUNDED THE DEFAULT WAY, TO THE 6TH DIGIT
        System.out.println(totalMoney.setScale(6, RoundingMode.HALF_EVEN));
        System.out.println(totalCustomers);
    }

    private static Integer[] parseArgsToInteger(String[] inputArgs) {
        Integer[] parsedResults = new Integer[inputArgs.length];

        for (int i = 0; i < inputArgs.length; i++) {
            parsedResults[i] = Integer.parseInt(inputArgs[i]);
        }

        return parsedResults;
    }

    private static Double[] parseArgsToDouble(String[] inputArgs) {
        Double[] parsedResults = new Double[inputArgs.length];

        for (int i = 0; i < inputArgs.length; i++) {
            parsedResults[i] = Double.parseDouble(inputArgs[i]);
        }

        return parsedResults;
    }
}
