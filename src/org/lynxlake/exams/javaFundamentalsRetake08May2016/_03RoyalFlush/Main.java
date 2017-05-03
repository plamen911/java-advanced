// https://judge.softuni.bg/Contests/Practice/Index/191#2
package org.lynxlake.exams.javaFundamentalsRetake08May2016._03RoyalFlush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Plamen Markov on 5/2/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine().trim());
        }

        final String regex = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)";
        final String string = sb.toString();

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        List<String> cardSequence = new LinkedList<>();

        while (matcher.find()) {
            cardSequence.add(matcher.group(0));
        }

        // 10-J-Q-K-A
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("J");
        list.add("Q");
        list.add("K");
        list.add("A");
        Map<String, List<String>> combinations = new HashMap<>();
        combinations.put("c", list);
        combinations.put("d", list);
        combinations.put("h", list);
        combinations.put("s", list);



        // checking sequence
//        for (Map.Entry<String, List<String>> stringListEntry : combinations.entrySet()) {
//            String suit = stringListEntry.getKey();
//            List<String> temp = stringListEntry.getValue();
//            for (String card : cardSequence) {
//                if (card.equals(temp.get(0) + suit)) {
//                    temp.remove(0);
//                }
//                if (temp.size() == 0) {
//                    break;
//                }
//            }
//        }
    }

    private static void checkRoyalFlush(List<String> cardSequence) {

    }


}
