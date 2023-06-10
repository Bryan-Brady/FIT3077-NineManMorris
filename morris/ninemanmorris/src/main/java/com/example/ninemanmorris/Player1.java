package com.example.ninemanmorris;

import java.util.ArrayList;

public class Player1 extends Player{
    private Player1() {
        super(PlayerType.PLAYER1);
    }

    private static Player1 player1_instance = null;
    public static synchronized Player1 getInstance()
    {
        if (player1_instance == null)
            player1_instance = new Player1();

        return player1_instance;
    }

}
