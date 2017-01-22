// https://judge.softuni.bg/Contests/Practice/Index/387#11
package org.lynxlake.multidimensionalArraysHomework._12ToTheStarsTests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] starOne = scanner.nextLine().split("\\s+");
        String[] starTwo = scanner.nextLine().split("\\s+");
        String[] starThree = scanner.nextLine().split("\\s+");
        String[] nInfo = scanner.nextLine().split("\\s+");
        double nX = Double.parseDouble(nInfo[0]);
        double nY = Double.parseDouble(nInfo[1]);
        int turns = Integer.parseInt(scanner.nextLine());

        String[] starNames = {starOne[0], starTwo[0], starThree[0]};
        double[] starX = {Double.parseDouble(starOne[1]), Double.parseDouble(starTwo[1]), Double.parseDouble(starThree[1])};
        double[] starY = {Double.parseDouble(starOne[2]), Double.parseDouble(starTwo[2]), Double.parseDouble(starThree[2])};

        for (int i = 0; i <= turns; i++) {
            boolean foundStar = false;
            for (int j = 0; j < 3; j++) {
                if (isInsideStar(nX, nY, starX[j], starY[j])) {
                    System.out.println(starNames[j].toLowerCase());
                    foundStar = true;
                    break;
                }
            }
            if (!foundStar) {
                System.out.println("space");
            }
            nY++;
        }
    }

    private static boolean isInsideStar(double nX, double nY, double sX, double sY) {
        return (nX <= sX + 1 && nX >= sX - 1) && (nY <= sY + 1 && nY >= sY - 1);
    }
}
