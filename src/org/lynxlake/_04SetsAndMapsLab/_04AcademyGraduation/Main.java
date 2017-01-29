// https://judge.softuni.bg/Contests/Practice/Index/388#4
package org.lynxlake._04SetsAndMapsLab._04AcademyGraduation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> results = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            String[] scores = scanner.nextLine().split("\\s+");
            double sumOfScore = 0;
            for (String scoresString : scores) {
                sumOfScore += Double.parseDouble(scoresString);
            }

            results.put(name, (sumOfScore / scores.length));
        }

        for (Map.Entry<String, Double> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
