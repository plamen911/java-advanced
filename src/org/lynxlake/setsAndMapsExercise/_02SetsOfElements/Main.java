// https://judge.softuni.bg/Contests/Practice/Index/188#1
package org.lynxlake.setsAndMapsExercise._02SetsOfElements;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().trim().split("\\s+");
        int n = Integer.valueOf(params[0]);
        int m = Integer.valueOf(params[1]);
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }
        for (int i = 0; i < m; i++) {
            set2.add(input.nextInt());
        }

        set.retainAll(set2);

        System.out.printf("%s", join(set, " "));
    }

    private static String join(Collection<?> s, String delimiter) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }
}