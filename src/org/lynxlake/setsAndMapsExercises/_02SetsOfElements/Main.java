// https://judge.softuni.bg/Contests/Practice/Index/188#1
package org.lynxlake.setsAndMapsExercises._02SetsOfElements;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setsSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i < setsSize[0] + setsSize[1]; i++) {
            if (i < setsSize[0]) {
                set1.add(scanner.nextLine());
            } else {
                set2.add(scanner.nextLine());
            }
        }

        set1.retainAll(set2);

        System.out.println(String.join(" ", set1));
    }
}
