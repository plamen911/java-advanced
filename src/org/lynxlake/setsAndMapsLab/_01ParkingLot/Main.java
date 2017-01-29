// https://judge.softuni.bg/Contests/Practice/Index/388#0
package org.lynxlake.setsAndMapsLab._01ParkingLot;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> parkingLot = new HashSet<String>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")) {
                    parkingLot.add(reminder[1]);
                } else {
                    parkingLot.remove(reminder[1]);
                }
            }
        }

        if (parkingLot.size() > 0) {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
