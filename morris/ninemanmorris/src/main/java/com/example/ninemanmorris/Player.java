package com.example.ninemanmorris;

import java.util.ArrayList;

public class Player {


    private int chipsReserve = 9;
    private int chipsAlive = 0;
    private int chipsDead = 0;
    private PlayerType playerType;
    private boolean millMade = false;
    private boolean playerMoved = false;
    public Player(PlayerType playerType){
        this.playerType = playerType;
    }
    private ArrayList<Chip> chips;
    public PlayerType getPlayerType(){
        return this.playerType;
    }

    /** This class returns a player object stating which is the current player that can
    * make their turn. E.g. currentPlayer is player1 after the turn change to player2
    * Input  : currentPlayer : The current player
    *          player1/2 : Are static objects
    * Return : currentPlayer, the player that can make their turn */
    public Player switchPlayerTurn(Player currentPlayer){
        currentPlayer.setPlayerMoved(false);
        return checkPlayerTurn(currentPlayer);
    }

    public Player checkPlayerTurn(Player currentPlayer){
        Board board = new Board();
        if (currentPlayer.getPlayerType() == PlayerType.PLAYER1) {
            // If current player is player 1 then change to player 2
            currentPlayer = board.getPlayer2();
        } else {
            currentPlayer = board.getPlayer1();
        }

        return currentPlayer;
    }
    public int getChipsReserve() {
        return chipsReserve;
    }

    public void reduceChipsReserve() {
        this.chipsReserve -= 1;
    }
    public void addChipsAlive() {
        this.chipsAlive += 1;
    }
    public void reduceChipsAlive(){
        this.chipsAlive -= 1;
        this.chipsDead += 1;
    }

    public int getChipsAlive() {
        return chipsAlive;
    }

    public void setChipsAlive(int chipsAlive) {
        this.chipsAlive = chipsAlive;
    }

    public int getChipsDead() {
        return chipsDead;
    }

    public void setChipsDead(int chipsDead) {
        this.chipsDead = chipsDead;
    }

    public boolean isPlayerMoved() {
        return playerMoved;
    }

    public void setPlayerMoved(boolean playerMoved) {
        this.playerMoved = playerMoved;
    }

    public boolean hasMill() {
        return millMade;
    }

    public void setMillMade(boolean millMade) {
        this.millMade = millMade;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void setChips(ArrayList<Chip> chips) {
        this.chips = chips;
    }
}
