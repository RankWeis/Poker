package com.kian.app.cards;

import java.util.ArrayList;

/**
 * Created by kian on 4/27/15.
 */
public class Hand {
    private ArrayList<Cards> hand = new ArrayList<>();
    private int handLimit;


    public Hand() {
        handLimit = 5;
    }


    public Hand(int handLimit) {
        handLimit = handLimit;
    }

    public boolean add(Cards card) {
        if(card == null || hand.size() >= handLimit) {
            return false;
        }
        return hand.add(card);
    }

    public Cards remove(int cardNumber) {
        if(hand.size() >= cardNumber) {
            return hand.remove(cardNumber);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder[] deckStrArr = new StringBuilder[10];
        for( Cards card : hand) {
            String[] cardRep = card.getStringRepresentation();
            for(int i = 0; i < cardRep.length; i++) {
                if(deckStrArr[i] == null) {
                    deckStrArr[i] = new StringBuilder(cardRep[i]);
                } else {
                    deckStrArr[i].append(" ").append(cardRep[i]);
                }
            }
        }
        StringBuilder deckStr = new StringBuilder();
        for(StringBuilder s : deckStrArr) {
            deckStr.append(s + "\n");
        }
        return deckStr.toString();
    }
}
