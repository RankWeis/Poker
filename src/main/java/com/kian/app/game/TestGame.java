package com.kian.app.game;

import com.kian.app.cards.Deck;
import com.kian.app.cards.Hand;

/**
 * Created by kian on 4/27/15.
 */
public class TestGame {
    private Hand hand = new Hand();
    private Deck deck = new Deck();

    public TestGame() {
        for(int i = 0; i < 5; i++) {
            hand.add(deck.deal());
        }

    }

    public String getHandText() {
        return hand.toString();
    }
}
