package com.example.ninemanmorris;

public class Player2 extends Player{
    private Player2() {
        super(PlayerType.PLAYER2);
    }

    private static Player2 player2_instance = null;
    public static synchronized Player2 getInstance()
    {
        if (player2_instance == null)
            player2_instance = new Player2();

        return player2_instance;
    }
}
