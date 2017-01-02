// https://judge.softuni.bg/Contests/Practice/Index/188#12
package org.lynxlake.setsAndMaps.srabskoUnleashed;

import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> venueList = new LinkedHashMap<>();
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("End")) {
                break;
            }
            if (!line.contains(" @")) {
                continue;
            }

            String[] params = line.split(" @");
            if (params.length != 2) {
                continue;
            }

            String singer = params[0].trim();
            String[] chunks = params[1].trim().split("\\s+");
            if (chunks.length < 3 || chunks.length > 5) continue;

            String venue = "";
            for (int i = 0; i < chunks.length - 2; i++) {
                venue += chunks[i] + " ";
            }
            venue = venue.trim();

            long ticketPrice;
            long ticketCount;
            try {
                ticketPrice = Long.parseLong(chunks[chunks.length - 2]);
                ticketCount = Long.parseLong(chunks[chunks.length - 1]);
            } catch (IllegalFormatException ex) {
                continue;
            } catch (Exception ex) {
                continue;
            }

            if (!venueList.containsKey(venue)) {
                venueList.put(venue, new LinkedHashMap<>());
            }
            if (!venueList.get(venue).containsKey(singer)) {
                venueList.get(venue).put(singer, 0L);
            }
            venueList.get(venue).put(singer, venueList.get(venue).get(singer) + ticketPrice * ticketCount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venueList.entrySet()) {
            System.out.printf("%s%n", venue.getKey());
            venue.getValue().entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .forEach(singer -> {
                        System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
                    });
        }
    }
}
