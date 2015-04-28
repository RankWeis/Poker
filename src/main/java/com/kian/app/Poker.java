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
        long i = 0;
        TestGame testGame = new TestGame();
        while(true) {
            if(!testGame.draw()) {
                testGame = new TestGame();
                testGame.draw();
            }
            String text = testGame.getHandText();
            System.out.println(text);
            System.out.println(i++);

        }
    }
}
