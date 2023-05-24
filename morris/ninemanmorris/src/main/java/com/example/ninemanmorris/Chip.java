package com.example.ninemanmorris;

import javafx.scene.shape.Circle;

public class Chip extends Circle {
    private ChipStatus chipStatus = ChipStatus.RESERVE;
    private Node chipLocation = null;
    private boolean isPartOfAMill;


    public Chip(){
        super();
    }

    /** Function that checks the chips if its a  player 1 or player 2 chip.

     Input :
     currentChip : The currently selected chip
     currentPlayer: The current player's turn

     Return  : currentChip : Returns the currentChip

     */
    public Chip checkPlayerChip(Chip thisChip, Player currentPlayer){
        /*
        To ensure only one player can click on their individual chip
        It takes the currentPlayer and the chip and sets that chip to the current player that is selected
        */
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

    // Getter for chips status
    public ChipStatus getChipStatus() {
        return chipStatus;
    }

    // Setter for chip status
    public void setChipStatus(ChipStatus chipStatus) {
        this.chipStatus = chipStatus;
    }

    // Getter for chips location
    public Node getChipLocation() {
        return chipLocation;
    }

    // Setter for chips location
    public void setChipLocation(Node chipLocation) {
        this.chipLocation = chipLocation;
    }

    public void setPartOfAMill(boolean partOfAMill) {
        isPartOfAMill = partOfAMill;
    }
}
