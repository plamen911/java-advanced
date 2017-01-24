// https://judge.softuni.bg/Contests/Practice/Index/187#6
package org.lynxlake.stacksAndQueuesHomework._07TruckTour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Station> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().trim().split(("\\s+"));
            int gas = Integer.parseInt(tokens[0]);
            int distance = Integer.parseInt(tokens[1]);

            Station station = new Station();
            station.gasGiven = gas;
            station.distanceToNext = distance;

            queue.addLast(station);
        }

        Integer gasInTank = 0;
        boolean foundFirst = false;
        Integer index = 0;

        while (true) {
            Station currentStation = queue.removeFirst();
            gasInTank += currentStation.gasGiven;
            queue.addLast(currentStation);

            Station firstStation = currentStation;
            Integer indexAddUp = 1;

            while (gasInTank >= currentStation.distanceToNext) {
                gasInTank -= currentStation.distanceToNext;
                currentStation = queue.removeFirst();
                queue.addLast(currentStation);
                gasInTank += currentStation.gasGiven;
                indexAddUp++;

                if (currentStation == firstStation) {
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst) {
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);

    }
}

class Station {
    int gasGiven;
    int distanceToNext;
}
