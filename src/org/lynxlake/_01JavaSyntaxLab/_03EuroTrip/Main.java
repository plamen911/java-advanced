// https://judge.softuni.bg/Contests/Practice/Index/382#2
package org.lynxlake._01JavaSyntaxLab._03EuroTrip;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double qty = scanner.nextDouble();

        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(1.20 * qty);
        BigDecimal totalPrice = priceInLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", totalPrice);
    }
}
