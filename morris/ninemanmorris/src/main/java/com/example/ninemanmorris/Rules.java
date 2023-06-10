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
    /** Function to check if the game is over. I.E, in this case, a losing condition has been met.

     Input :
     player1 : The current player1
     player2 : The current player2
     ChipsP1ArrayList: the array list of player 1's chips
     ChipsP2ArrayList: the array list of player 2's chips


     Return  : Null OR player1/player2 (winners) if losing conditions are met

     */
    public Player isGameEnd(Player player1, Player player2, ArrayList<Chip> chipsP1ArrayList, ArrayList<Chip> chipsP2ArrayList){
        /** will return the winner **/
        boolean stillCanMoveRemainingThree1 = true;
        boolean stillCanMoveAdjacent1 = false;
        boolean stillCanMoveRemainingThree2 = true;
        boolean stillCanMoveAdjacent2 = false;

//        System.out.println("P1 array: ");
//        System.out.println(chipsP1Array);

//        System.out.println("P1 arraylist: ");
//        System.out.println(chipsP1ArrayList);

//        System.out.println("P2 array: ");
//        System.out.println(chipsP2Array);
//
//        System.out.println("P2 arraylist: ");
//        System.out.println(chipsP2ArrayList);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
        //Checks for validity of adjacent moves for:
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Player 1");
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        for(Chip chip : chipsP1ArrayList){
//            System.out.println("P1: ");
//            System.out.println(chip);
            // Quick check to see if chip not null, is set onto a location, and is alive (is alive is here to resolve strange bug)
            if(chip != null && chip.getChipLocation() != null && (chip.getChipStatus() == ChipStatus.ALIVE)) {
                stillCanMoveRemainingThree1 = this.isRemainingThreeMoveCondition(player1);
                for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                    // The only instance where any player lose because of no more legal moves, is if ALL the neighboring nodes
                    // have a chip in it. (parent node also needs to be alive)

                    // So, move adjacent will always be false UNLESS there is a neighbour with NO chip.
                    // If neighbour = no chip, still has a legal move (if statement below catches that)
                    // but if all neighbour = occupied by a chip, then it will still be false (by default) which means
                    // player no longer has legal adjacent move

                    if (node.getChip() == null) {
                        // Any instance of no chip in neighbouring nodes, still have legal move.
//                        System.out.println("LEGAL MOVE AVAILABLE ON NODE: ");
//                        System.out.println(node.getId());
//                        System.out.println("NEIGHBOUR OF (parent): ");
//                        System.out.println(chip.getChipLocation().getId());

                        stillCanMoveAdjacent1 = true;
                    }
//                    else {
//                        System.out.println("Invalid adjacent movement");
//                        System.out.println(node.getId());
//                        System.out.println(chip.getChipLocation().getId());
//                    }
                }
            }
        }

        // the same logic applies for player 2
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Player 2");
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        for(Chip chip : chipsP2ArrayList){
//            System.out.println("P2: ");
//            System.out.println(chip);
            if(chip != null && chip.getChipLocation() != null && (chip.getChipStatus() == ChipStatus.ALIVE)) {
                stillCanMoveRemainingThree2 = this.isRemainingThreeMoveCondition(player2);
                for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                    if (node.getChip() == null) {
//                        System.out.println("LEGAL MOVE AVAILABLE ON NODE: ");
//                        System.out.println(node.getId());
//                        System.out.println("NEIGHBOUR OF (parent): ");
//                        System.out.println(chip.getChipLocation().getId());
                        stillCanMoveAdjacent2 = true;

                    }
//                    else {
//                        System.out.println("Invalid adjacent movement");
//                        System.out.println(node.getId());
//                        System.out.println(chip.getChipLocation().getId());
//                    }
                }
            }
        }
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

        //Condition of losing:
        //Scenario 1:
        // - player more than 3 ALIVE chips             AND
        // - player cannot move adjacent                AND
        // - both players have placed all their chips

        //Scenario 2:
        // - player less than 3 ALIVE chips             AND
        // - player have placed all their chip
        if((!stillCanMoveRemainingThree1 && !stillCanMoveAdjacent1 && (player1.getChipsReserve() == 0 && player2.getChipsReserve() == 0) || (player1.getChipsAlive() == 2 && player1.getChipsReserve() == 0) )){
            System.out.println("Player 2 epic victory royale");

            // No more legal moves
            System.out.println("Player 1 lost via: ");
            System.out.println("No legal moves? ");
            System.out.println(!stillCanMoveRemainingThree1 && !stillCanMoveAdjacent1);

            // Chips alive lesser than 3 (2)
            System.out.println("Chips lesser than 3 (or == 2) ");
            System.out.println(player1.getChipsAlive() == 2 && player1.getChipsReserve() == 0);
            return player2;
        }
        if((!stillCanMoveRemainingThree2 && !stillCanMoveAdjacent2 && (player1.getChipsReserve() == 0 && player2.getChipsReserve() == 0) || (player2.getChipsAlive() == 2 && player2.getChipsReserve() == 0) )){
            System.out.println("Player 1 chicken dinner");

            // No more legal moves
            System.out.println("Player 2 lost via: ");
            System.out.println("No legal moves? ");
            System.out.println(!stillCanMoveRemainingThree2 && !stillCanMoveAdjacent2);

            // Chips alive lesser than 3 (2)
            System.out.println("Chips lesser than 3 (or == 2) ");
            System.out.println(player2.getChipsAlive() == 2 && player2.getChipsReserve() == 0);
            return player1;
        }
        return null;
    }

    public boolean isInitialMoveCondition( Player currentPlayer){
        return (currentPlayer.getChipsReserve() <= 9 && currentPlayer.getChipsReserve() != 0  && !currentPlayer.isPlayerMoved());
    }

    public boolean isRemainingThreeMoveCondition( Player currentPlayer){
        return (currentPlayer.getChipsAlive() <= 3 && currentPlayer.getChipsReserve() == 0  && !currentPlayer.isPlayerMoved());
    }
    public boolean isMoveAdjacent( Player currentPlayer){
        return (currentPlayer.getChipsReserve() == 0  && !currentPlayer.isPlayerMoved());
    }

}
