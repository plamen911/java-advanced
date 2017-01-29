// https://judge.softuni.bg/Contests/Practice/Index/381#0
package org.lynxlake._02MultidimensionalArraysLab._01ReadSortPrintArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] names = new String[length];

        for (int i = 0; i < length; i++) {
            names[i] = scanner.nextLine();
        }

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
