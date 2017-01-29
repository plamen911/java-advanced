// https://judge.softuni.bg/Contests/Practice/Index/388#1
package org.lynxlake.setsAndMapsLab._02SoftUniParty;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while (true) {
            String input = scanner.nextLine();
            if ("PARTY".equals(input)) {
                break;
            } else {
                String sign = Character.toString(input.charAt(0));
                if (numbers.contains(sign)) {
                    vip.add(input);
                } else {
                    regular.add(input);
                }
            }
        }

        while (true) {
            String guestsCome = scanner.nextLine();
            if ("END".equals(guestsCome)) {
                break;
            }
            String sign = Character.toString(guestsCome.charAt(0));
            if (numbers.contains(sign)) {
                vip.remove(guestsCome);
            } else {
                regular.remove(guestsCome);
            }
        }

        vip.addAll(regular);

        System.out.println(vip.size());
        for (String s : vip) {
            System.out.println(s);
        }
    }
}
