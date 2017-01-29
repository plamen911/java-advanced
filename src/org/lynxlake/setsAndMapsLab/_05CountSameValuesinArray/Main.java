// https://judge.softuni.bg/Contests/Practice/Index/388#3
package org.lynxlake.setsAndMapsLab._05CountSameValuesinArray;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        HashMap<String, Integer> result = new HashMap<>();

        for (String number : input) {
            if (!result.containsKey(number)) {
                result.put(number, 1);
            } else {
                result.put(number, result.get(number) + 1);
            }
        }

        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key) + " times");
        }
    }
}
