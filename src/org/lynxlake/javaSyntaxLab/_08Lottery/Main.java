// https://judge.softuni.bg/Contests/Practice/Index/382#7
package org.lynxlake.javaSyntaxLab._08Lottery;

public class Main {
    public static void main(String[] args) {
        for (int n1 = 1; n1 <= 8; n1++) {
            for (int n2 = n1 + 1; n2 <= 9; n2++) {
                for (int n3 = n2 + 1; n3 <= 10; n3++) {
                    System.out.printf("%s %s %s%n", n1, n2, n3);
                }
            }
        }
    }
}
