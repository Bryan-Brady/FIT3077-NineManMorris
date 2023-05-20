package com.example.ninemanmorris;

import java.util.Arrays;

public class Move {
    private static Move move_instance = null;

    public String s;
    private Move(){
        s = "This is a move singleton class";
    }

    // Create Singleton class of move
    public static synchronized Move getInstance(){
        if(move_instance == null){
            move_instance = new Move();
        }
        return move_instance;
    }
    private void setPos(Chip currentChip,Node thisNode, Player currentPlayer){

        // Setting the chips on the board position
        currentChip.setLayoutX(thisNode.getLayoutX());
        currentChip.setLayoutY(thisNode.getLayoutY());
        currentChip.setChipLocation(thisNode);
        System.out.println("IN SET POS");
        currentPlayer.setPlayerMoved(true);

    }
    public void moveAnyWhere(Chip currentChip,Node thisNode, Player currentPlayer){
        boolean initialMoveCondition = (currentPlayer.getChipsReserve() <= 9 && currentPlayer.getChipsReserve() != 0 && currentChip.getChipStatus() == ChipStatus.RESERVE);
        boolean remainingThreeMoveCondition = (currentPlayer.getChipsAlive() <= 3 && currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE);
        if(initialMoveCondition){
            // Can move anywhere
            this.setPos(currentChip, thisNode, currentPlayer);
            // Set status on the chip, stating it is on the board
            currentChip.setChipStatus(ChipStatus.ALIVE);
            // Reduce chips reserve
            currentPlayer.reduceChipsReserve();
        }

        if(remainingThreeMoveCondition){

            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

    public void moveKillChip(Chip currentChip, Node thisNode){

    }

    public void moveAdjacent(Chip currentChip, Node thisNode, Player currentPlayer){
        boolean moveAdjacentCondition = (currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE);
        // Move adjacent
        if(Arrays.asList(thisNode.getNodeNeighbours()).contains(currentChip.getChipLocation()) && moveAdjacentCondition){
            System.out.println("IN MOVE ADJ");
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

}
