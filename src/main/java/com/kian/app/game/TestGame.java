package com.kian.app.game;

import com.kian.app.cards.Deck;
import com.kian.app.cards.Hand;
import com.kian.app.evaluation.PokerEvaluation;

/**
 * Created by kian on 4/27/15.
 */
public class TestGame {
    private Hand hand = new Hand();
    private Deck deck = new Deck();
    private PokerEvaluation pokerEvaluation = new PokerEvaluation();

    public TestGame() {
        draw();
    }



    public boolean draw() {
        if(deck.getSize() >= 5) {
            hand.clear();
            for(int i = 0; i < 5; i++) {
                hand.add(deck.deal());
            }
            return true;
        }
        return false;
    }

    public String getHandText() {
        String text = hand.toString();
        PokerEvaluation.PokerHands pokerHand = pokerEvaluation.evaluateHand(hand);
        return text + "\n\n\n" + "Best Hand: " + pokerHand.getStringEvaluation();

    }

}
