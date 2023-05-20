package com.example.ninemanmorris;

public class Player {


    private int chipsLeft;
    private PlayerType playerType;
    public Player(PlayerType playerType){
        this.playerType = playerType;
    }
    public void setChipsLeft(int chipsLeft) {
        //somehow initialize a status variable so each ball can know which node has a ball
        this.chipsLeft = chipsLeft;
    }
    public int getChipsLeft(){
        return this.chipsLeft;
    }
    public void setPlayerType(PlayerType playerType) {
        //somehow initialize a status variable so each ball can know which node has a ball
        this.playerType = playerType;
    }
    public PlayerType getPlayerType(){
        return this.playerType;
    }
}
