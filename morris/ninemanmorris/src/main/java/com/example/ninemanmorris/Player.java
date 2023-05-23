package com.example.ninemanmorris;

public class Player {


    private int chipsReserve = 9;
    private int chipsAlive = 0;
    private int chipsDead = 0;
    private PlayerType playerType;
<<<<<<< Updated upstream
=======
    private boolean millMade = false;
>>>>>>> Stashed changes
    private boolean playerMoved = false;
    public Player(PlayerType playerType){
        this.playerType = playerType;
    }

    public PlayerType getPlayerType(){
        return this.playerType;
    }

    /** This class returns a player object stating which is the current player that can
    * make their turn. E.g. currentPlayer is player1 after the turn change to player2
    * Input  : currentPlayer : The current player
    *          player1/2 : Are static objects
    * Return : currentPlayer, the player that can make their turn */
<<<<<<< Updated upstream
    public Player playerTurn(Player currentPlayer){
        Board board = new Board();
        Player thePlayer = currentPlayer;
        if(thePlayer.getPlayerType() == PlayerType.PLAYER1){
            // If current player is player 1 then change to player 2
            thePlayer = board.getPlayer2();
            System.out.println("Current Player:" + currentPlayer.getPlayerType());
        }else {
            // It means the current player is player 2 so change it to player 1
            thePlayer = board.getPlayer1();
            System.out.println("Current Player:" + currentPlayer.getPlayerType());
        }
=======
    public Player checkPlayerTurn(Player currentPlayer){
        Board board = new Board();
        Player thePlayer = currentPlayer;
        // Set the current player to end their turn
        thePlayer.setPlayerMoved(false);
        if (thePlayer.getPlayerType() == PlayerType.PLAYER1) {
            // If current player is player 1 then change to player 2
            thePlayer = board.getPlayer2();
//            System.out.println("Current Player:" + thePlayer.getPlayerType());
        } else {
            // It means the current player is player 2 so change it to player 1
            thePlayer = board.getPlayer1();
//            System.out.println("Current Player:" + thePlayer.getPlayerType());
        }

>>>>>>> Stashed changes
        return thePlayer;
    }

    public int getChipsReserve() {
        return chipsReserve;
    }

    public void reduceChipsReserve() {
        this.chipsReserve -= 1;
    }
<<<<<<< Updated upstream
=======
    public void addChipsAlive() {
        this.chipsAlive += 1;
    }
    public void reduceChipsAlive(){
        this.chipsAlive -= 1;
        this.chipsDead += 1;
    }
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======

    public boolean hasMill() {
        return millMade;
    }

    public void setMillMade(boolean millMade) {
        this.millMade = millMade;
    }
>>>>>>> Stashed changes
}
