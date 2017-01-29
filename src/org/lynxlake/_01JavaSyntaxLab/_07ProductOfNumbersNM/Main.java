// https://judge.softuni.bg/Contests/Practice/Index/382#6
package org.lynxlake._01JavaSyntaxLab._07ProductOfNumbersNM;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int index = n;
        BigInteger product = new BigInteger("1");

        do {
            product = product.multiply(new BigInteger(String.valueOf(index)));
            index++;
        } while (index <= m);

        System.out.printf("product[%s..%s] = %s", n, m, product);
    }
}
