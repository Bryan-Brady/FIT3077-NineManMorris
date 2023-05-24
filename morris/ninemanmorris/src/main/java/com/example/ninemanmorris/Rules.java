package com.example.ninemanmorris;

import java.util.ArrayList;
import java.util.Arrays;

public class Rules {
    public Rules(){
    }

    /** Function to set the Mill status of the board; if a mill was created by a particular line, set the chip to
     * be part of the mill so that it cannot be removed.

     Input : lineArray :  The array of the possible lines which a mill can be made *
     Return  : N/A

     */
    public void setMillStatusBoard(Line[] lineArray){
        for(Line line : lineArray) {
            boolean millCreated = this.isMillMade(line);
            if(millCreated){
                // If mill is created, set the chip to be part of a mill so that it could not be removed
                line.setAllLineMemberMillStatus(true);
                /* Set the line to be a mill as well, so that it can make sure that nodes that have two lines
                are still a mill even though one line of the node is not a mill anymore*/
                line.setAMill(true);
            } else {
                line.setAllLineMemberMillStatus(false);
                line.setAMill(false);
            }
        }

    }
    /** Function to check if a mill has been made

     Input : line : The group of nodes where a mill can be made *
     Return  : millCreated : Boolean, true/false if a mill is made

     */
    public boolean isMillMade(Line line) {
        ArrayList<Chip> chipsToBeCompared = new ArrayList<Chip>();
        boolean millCreated = false;
        for(Node node : line.getLineMember()) {
            Chip chip = node.getChip();
            if(chip != null) {
                // If node hold a chip
                chipsToBeCompared.add(chip);
            }
        }
        if(chipsToBeCompared.size() == 3){
            String firstChipId = chipsToBeCompared.get(0).getId();
            String secondChipId = chipsToBeCompared.get(1).getId();
            String thirdChipId = chipsToBeCompared.get(2).getId();
            System.out.println(firstChipId);
            System.out.println(secondChipId);
            System.out.println(thirdChipId);
            if(firstChipId.charAt(1) == secondChipId.charAt(1) && firstChipId.charAt(1) == thirdChipId.charAt(1)){
                millCreated = true;
                line.setAMill(true);
                line.setAllLineMemberMillStatus(true);
            }
        }
        return millCreated;
    }


    /** Function to check if the target chip is part of another mill (IMPORTANT)

     Input :
     targetChip : The chip that will be checked *


     Return  : A boolean flag indicating if the chip is part of another mill or not

     */
    public boolean chipIsPartOfMill(Chip targetChip){
        // The line that is associated with this chip
        ArrayList<Line> chipLineGroup = targetChip.getChipLocation().getLinePart();
        boolean line1 = chipLineGroup.get(0).isAMill();
        boolean line2= chipLineGroup.get(1).isAMill();
        if(line1 || line2){
            targetChip.setPartOfAMill(true);
            return true;
        }else{
            targetChip.setPartOfAMill(false);
            return false;
        }
    }
    /** Function to check if the game is over I.E, a win condition has been met

     Input :
     player1 : The current player1 *
     player2 : The current player2
     ChipsP1Array: the array of player 1's chips
     ChipsP2Array: the array of player 2's chips


     Return  : Null

     */
    public Player isGameEnd(Player player1, Player player2, Chip[] chipsP1Array, Chip[] chipsP2Array){
        /** will return the loser **/
        boolean stillCanMoveRemainingThree1 = true;
        boolean stillCanMoveAdjacent1 = true;
        boolean stillCanMoveRemainingThree2 = true;
        boolean stillCanMoveAdjacent2 = true;
        // If no more valid moves
        for(Chip chip : chipsP1Array){
            if(chip != null) {
                stillCanMoveRemainingThree1 = this.isRemainingThreeMoveCondition(chip, player1);
                for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                    if (node.getChip() == null) {
                        // Means no chip present so can make move
                        stillCanMoveAdjacent1 = false;
                    } else {
                        stillCanMoveAdjacent1 = true;
                    }
                }
            }
        }

        for(Chip chip : chipsP2Array){
            if(chip != null) {
                stillCanMoveRemainingThree2 = this.isRemainingThreeMoveCondition(chip, player2);
                for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                    if (node.getChip() == null) {
                        // Means no chip present so can make move
                        stillCanMoveAdjacent2 = false;
                    } else {
                        stillCanMoveAdjacent2 = true;
                    }
                }
            }
        }
        if((!stillCanMoveRemainingThree1 && !stillCanMoveAdjacent1 )|| (player1.getChipsAlive() == 2 && player1.getChipsReserve() == 0) ){
            return player1;
        }
        if((!stillCanMoveRemainingThree2 && !stillCanMoveAdjacent2 ) ||(player2.getChipsAlive() == 2 && player1.getChipsReserve() == 0) ){
            return player2;
        }
        return null;
    }

    public boolean isInitialMoveCondition(Chip currentChip, Player currentPlayer){
        return (currentPlayer.getChipsReserve() <= 9 && currentPlayer.getChipsReserve() != 0 && currentChip.getChipStatus() == ChipStatus.RESERVE && !currentPlayer.isPlayerMoved());
    }

    public boolean isRemainingThreeMoveCondition(Chip currentChip, Player currentPlayer){
        return (currentPlayer.getChipsAlive() <= 3 && currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE && !currentPlayer.isPlayerMoved());
    }
    public boolean isMoveAdjacent(Chip currentChip, Node thisNode,  Player currentPlayer){
        return (currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE && !currentPlayer.isPlayerMoved() && Arrays.asList(thisNode.getNodeNeighbours()).contains(currentChip.getChipLocation()));
    }

}
