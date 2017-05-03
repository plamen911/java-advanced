// https://judge.softuni.bg/Contests/Compete/Index/549#0
package org.lynxlake.exams.retakeExam03May2017._01HandScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Plamen Markov on 5/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = reader.readLine().trim().split("\\s+");

        String cardSuitInSequence = "";
        List<Integer> sequence = new ArrayList<>();
        int handScore = 0;

        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];
            String cardFace = card.substring(0, card.length() - 1);
            String cardSuit = card.substring(card.length() - 1);
            int cardValue = getCardValue(cardFace);

            // if not last
            if (i < cards.length - 1) {
                String nextCard = cards[i + 1];
                String nextCardSuit = nextCard.substring(nextCard.length() - 1);

                // there is a sequence
                if (cardSuit.equals(nextCardSuit)) {
                    sequence.add(cardValue);
                    cardSuitInSequence = cardSuit;
                }
                // is the last of sequence?
                else if (!cardSuit.equals(nextCardSuit) && sequence.size() > 0) {
                    sequence.add(cardValue);
                    int sequenceSum = 0;
                    for (Integer integer : sequence) {
                        sequenceSum += integer;
                    }
                    handScore += sequenceSum * sequence.size();
                    sequence.clear();
                    cardSuitInSequence = "";
                } else {
                    handScore += cardValue;
                }
            } else {
                // it's the last element
                if (sequence.size() > 0 && cardSuit.equals(cardSuitInSequence)) {
                    sequence.add(cardValue);
                } else {
                    handScore += cardValue;
                }
            }
        }

        // is there a sequence?
        if (sequence.size() > 0) {
            int sequenceSum = 0;
            for (Integer integer : sequence) {
                sequenceSum += integer;
            }
            handScore += sequenceSum * sequence.size();
        }

        System.out.println(handScore);
    }

    private static int getCardValue(String cardFace) {
        HashMap<String, Integer> cardValues = new HashMap<>();
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("J", 12);
        cardValues.put("Q", 13);
        cardValues.put("K", 14);
        cardValues.put("A", 15);

        return cardValues.get(cardFace);
    }
}
