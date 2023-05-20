package com.example.ninemanmorris;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;

public class Chip extends Circle {
    private ChipStatus chipStatus = ChipStatus.RESERVE;
    private Node chipLocation;



    public Chip(){
        super();
    }

    public Chip checkPlayerChip(Chip thisChip, Player currentPlayer){
        // To make sure that only player1 can click chip1 likewise for player2
        boolean correctChip1 = thisChip.getId().startsWith("p1");
        boolean correctChip2 = thisChip.getId().startsWith("p2");
        Chip currentChip = null;
        if(currentPlayer.getPlayerType() == PlayerType.PLAYER1 && correctChip1){
            // If chip belong to player 1
            currentChip = thisChip;
        }

        if(currentPlayer.getPlayerType() == PlayerType.PLAYER2 && correctChip2){
            // If chip belong to player 2
            currentChip = thisChip;
        }
        return currentChip;
    }

    public ChipStatus getChipStatus() {
        return chipStatus;
    }

    public void setChipStatus(ChipStatus chipStatus) {
        this.chipStatus = chipStatus;
    }
    public Node getChipLocation() {
        return chipLocation;
    }

    public void setChipLocation(Node chipLocation) {
        this.chipLocation = chipLocation;
    }
}
