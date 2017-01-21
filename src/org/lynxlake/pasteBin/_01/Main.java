// http://pastebin.com/BineZezf
package org.lynxlake.pasteBin._01;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> nestedMap = new LinkedHashMap<>();

        String country = "Bulgaria";
        String city = "Sofia";
        int population = 1000000;

        nestedMap.put(city, population);
        map.put(country, nestedMap);

        map.entrySet().forEach(entry -> {
            //System.out.printf("%s (total population: %d)%n", entry.getKey(), // TO DO Finish here);
            for (LinkedHashMap<String, Integer> linkedHashMap : map.values()) {
                for (Map.Entry<String, Integer> cityMap : linkedHashMap.entrySet()) {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), cityMap.getValue());
                }
            }
        });
    }
}
