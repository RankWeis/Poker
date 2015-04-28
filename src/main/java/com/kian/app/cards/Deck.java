package com.kian.app.cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kian on 4/27/15.
 */
public class Deck {
    private ArrayList<Cards> deck = new ArrayList<>();

    public Deck() {
        initializeDeck();
        shuffle();
    }

    public Cards deal() {
        if(deck.isEmpty()) {
            return null;
        }
        return deck.remove(0);
    }

    private void initializeDeck() {
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j < 4; j++) {
                Cards.Suite suite = null;
                switch (j) {
                    case 0:
                        suite = Cards.Suite.SPADES;
                        break;
                    case 1:
                        suite = Cards.Suite.CLUBS;
                        break;
                    case 2:
                        suite = Cards.Suite.DIAMONDS;
                        break;
                    case 3:
                        suite = Cards.Suite.HEARTS;
                        break;
                }
                deck.add(new Cards(Cards.Card.values()[i], suite));
            }
        }

    }

    private void shuffle() {
        ArrayList<Cards> temp = new ArrayList<>();
        Random rand = new Random();
        while(!deck.isEmpty()) {
            int card = rand.nextInt(deck.size());
            temp.add(deck.remove(card));
        }
        this.deck = temp;
    }
}
