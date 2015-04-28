package com.kian.app;

import com.kian.app.game.TestGame;

/**
 * Hello world!
 *
 */
public class Poker
{
    public static void main( String[] args )
    {
        TestGame testGame = new TestGame();
        System.out.println( testGame.getHandText());
    }
}
