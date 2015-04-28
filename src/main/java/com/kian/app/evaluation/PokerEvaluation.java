package com.kian.app.evaluation;

import com.kian.app.cards.Cards;
import com.kian.app.cards.Hand;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kian on 4/28/15.
 */
public class PokerEvaluation implements HandEvaluation {

    public enum PokerHands {
        HIGH_CARD("High Card"),
        ONE_PAIR("One Pair"),
        TWO_PAIR("Two Pair"),
        THREE_OF_A_KIND("Three of a Kind"),
        STRAIGHT("Straight"),
        FLUSH("Flush"),
        FULL_HOUSE("Full House"),
        FOUR_OF_A_KIND("Four of a Kind"),
        STRAIGHT_FLUSH("Straight Flush");

        String stringEvaluation;

        PokerHands(String stringEvaluation) {
            this.stringEvaluation = stringEvaluation;
        }

        public String getStringEvaluation() {
            return stringEvaluation;
        }
    }

    public PokerHands evaluateHand(Hand hand) {
        ArrayList<Integer> numericHand = new ArrayList<>();
        ArrayList<Integer> countedPair = new ArrayList<>();
        boolean flush = true;
        boolean straight = true;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;
        boolean pair = false;
        boolean twoPair = false;
        ArrayList<Cards> cards = hand.getCards();
        Cards.Suite firstCard = cards.get(0).getSuite();
        for (Cards card : cards) {
            if (flush && card.getSuite() != firstCard) {
                flush = false;
            }
            numericHand.add(card.getCard().getValue());
        }
        Collections.sort(numericHand);
        for (int i = 0; i < 5; i++) {
            int current = numericHand.get(i);
            if (current - i != numericHand.get(0)) {
                straight = false;
            }
            if (!countedPair.contains(current)) {
                int repeats = countNum(current, numericHand);
                countedPair.add(current);
                if (repeats == 2) {
                    if (pair == true) {
                        twoPair = true;
                    } else {
                        pair = true;
                    }
                }
                if (repeats == 3) {
                    threeOfAKind = true;
                }
                if (repeats == 4) {
                    fourOfAKind = true;
                }
            }
        }
        if (straight) {
            if (flush) {
                return PokerHands.STRAIGHT_FLUSH;
            }
            return PokerHands.STRAIGHT;
        }
        if (fourOfAKind) {
            return PokerHands.FOUR_OF_A_KIND;
        }
        if (threeOfAKind) {
            if (pair) {
                return PokerHands.FULL_HOUSE;
            } else if (flush) {
                return PokerHands.FLUSH;
            }
            return PokerHands.THREE_OF_A_KIND;
        }
        if (flush) {
            return PokerHands.FLUSH;
        }
        if (straight) {
            return PokerHands.STRAIGHT;
        }
        if (twoPair) {
            return PokerHands.TWO_PAIR;
        }
        if (pair) {
            return PokerHands.ONE_PAIR;
        }
        return PokerHands.HIGH_CARD;

    }

    private int countNum(int num, ArrayList<Integer> numericHand) {
        int count = 0;
        for (Integer i : numericHand) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }
}
