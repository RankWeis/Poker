package com.kian.app.cards;

/**
 * Created by kian on 4/27/15.
 */
public class Cards {
    private Card card;
    private Suite suite;

    public enum Suite {
        SPADES('\u2660'),
        CLUBS('\u2663'),
        HEARTS('\u2665'),
        DIAMONDS('\u2666');

        char representation;

        Suite(char symbol) {
            this.representation = symbol;
        }


    }

    public enum Card {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J", "Jack", 11),
        QUEEN("Q", "Queen", 12),
        KING("K", "King", 13),
        ACE("A", "Ace", 14);

        String representation;
        int value;
        String fullName;

        Card(String representation) {
            this.representation = representation;
            this.value = Integer.valueOf(representation);
            this.fullName = representation;
        }

        Card(String representation, String fullName, int value) {
            this.representation = representation;
            this.value = value;
            this.fullName = fullName;
        }

        public String getRepresentation() {
            return representation;
        }

        public int getValue() {
            return value;
        }

        public String getFullName() {
            return fullName;
        }
    }

    public Cards(Card card , Suite suite) {
        this.card = card;
        this.suite = suite;
    }

    String[] getStringRepresentation() {
        String[] stringRepresentation = new String[10];
        String padding = this.card.representation.length() == 1 ? "         " : "       ";
        stringRepresentation[0] = stringRepresentation[9] = "---------------";
        stringRepresentation[1] = stringRepresentation[8] = "| " + this.card.representation  + padding
                + this.card.representation + " |";
        stringRepresentation[2] = stringRepresentation[7] = "| " + this.suite.representation + "         " + this.suite.representation + " |";
        for (int i = 3; i < 7; i++) {
            stringRepresentation[i] = "|             |";
        }
        return stringRepresentation;
    }

    public Card getCard() {
        return card;
    }

    public Suite getSuite() {
        return suite;
    }
}
