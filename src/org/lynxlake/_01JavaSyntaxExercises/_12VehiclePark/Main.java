// https://judge.softuni.bg/Contests/Practice/Index/383#11
package org.lynxlake._01JavaSyntaxExercises._12VehiclePark;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carsForSelling = scanner.nextLine().trim().split("\\s+");
        ArrayList<String> vehiclesLeft = new ArrayList<>(Arrays.asList(carsForSelling));
        int numberOfSold = 0;

        while (true) {
            String[] params = scanner.nextLine().trim().split("\\s+");
            if (params[0].equalsIgnoreCase("End")) {
                break;
            }
            String vehicleType = params[0];
            int numberOfSeats = Integer.parseInt(params[2]);
            char firstLetter = vehicleType.toLowerCase().charAt(0);
            int price = (int)firstLetter * numberOfSeats;

            String car = String.format("%c%d", firstLetter, numberOfSeats);
            if (vehiclesLeft.contains(car)) {
                vehiclesLeft.remove(vehiclesLeft.indexOf(car));
                System.out.printf("Yes, sold for %d$%n", price);
                numberOfSold++;
            } else {
                System.out.println("No");
            }
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", vehiclesLeft));
        System.out.printf("Vehicles sold: %d%n", numberOfSold);
    }
}
